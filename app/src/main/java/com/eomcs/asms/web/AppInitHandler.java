package com.eomcs.asms.web;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.asms.dao.AnimalDao;
import com.eomcs.asms.dao.BoardDao;
import com.eomcs.asms.dao.ManagerDao;
import com.eomcs.asms.dao.MemberDao;
import com.eomcs.asms.service.AnimalService;
import com.eomcs.asms.service.BoardService;
import com.eomcs.asms.service.ManagerService;
import com.eomcs.asms.service.MemberService;
import com.eomcs.asms.service.impl.DefaultAnimalService;
import com.eomcs.asms.service.impl.DefaultBoardService;
import com.eomcs.asms.service.impl.DefaultManagerService;
import com.eomcs.asms.service.impl.DefaultMemberService;
import com.eomcs.mybatis.MybatisDaoFactory;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

@WebServlet(
    value="/init",   // 클라인언트에서 요청할 때 사용할 명령이다.
    loadOnStartup = 1 // 톰캣 서버를 실행할 때 이 객체를 생성하라고 지정한다.
    )
// loadOnStartup 이 지정되지 않은 경우, 
// 클라이언트가 실행을 요청할 때 서블릿 객체를 생성한다.
// 물론 한 번 객체를 생성하면 그 생성된 객체를 계속 사용한다.
// 즉 두 개의 객체를 생성하진 않는다.
public class AppInitHandler implements Servlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    // 서블릿 객체를 생성할 때 톰캣 서버가 호출하는 메서드
    // => 보통 서블릿들이 사용할 의존 객체를 준비하는 등의 일을 한다.

    try {
      // 1) Mybatis 관련 객체 준비
      InputStream mybatisConfigStream = Resources.getResourceAsStream(
          "com/eomcs/pms/conf/mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigStream);
      SqlSessionFactoryProxy sqlSessionFactoryProxy = new SqlSessionFactoryProxy(sqlSessionFactory);

      // 2) DAO 관련 객체 준비
      MybatisDaoFactory daoFactory = new MybatisDaoFactory(sqlSessionFactoryProxy);
      BoardDao boardDao = daoFactory.createDao(BoardDao.class);
      MemberDao memberDao = daoFactory.createDao(MemberDao.class);
      AnimalDao animalDao = daoFactory.createDao(AnimalDao.class);
      ManagerDao managerDao = daoFactory.createDao(ManagerDao.class);

      // 3) 서비스 관련 객체 준비
      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);

      BoardService boardService = new DefaultBoardService(boardDao);
      MemberService memberService = new DefaultMemberService(memberDao);
      AnimalService animalService = new DefaultAnimalService(animalDao);
      ManagerService mangerService = new DefaultManagerService(managerDao);

      // 4) 서비스 객체를 ServletContext 보관소에 저장한다.
      ServletContext servletContext = config.getServletContext();

      servletContext.setAttribute("boardService", boardService);
      servletContext.setAttribute("memberService", memberService);
      servletContext.setAttribute("animalService", animalService);
      servletContext.setAttribute("mangerService", mangerService);

      System.out.println("의존 객체를 모두 준비하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void destroy() {
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
  }

}
