package com.eomcs.asms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.eomcs.asms.dao.ManagerDao;
import com.eomcs.asms.domain.Manager;
import com.eomcs.asms.service.ManagerService;

public class DefaultManagerService implements ManagerService {

  ManagerDao managerDao;

  public DefaultManagerService(ManagerDao managerDao) {
    this.managerDao = managerDao;
  }  

  // 등록 업무
  @Override
  public int add(Manager manager) throws Exception {
    return managerDao.insert(manager);
  }

  // 조회 업무
  @Override
  public List<Manager> list() throws Exception {
    return managerDao.findAll();
  }

  // 상세 조회 업무
  @Override
  public Manager get(int no) throws Exception {
    return managerDao.findByNo(no);
  }

  // 사용자 조회 업무
  @Override
  public Manager get(String email, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);

    return managerDao.findByEmailPassword(params);
  }

  // 변경 업무
  @Override
  public int update(Manager manager) throws Exception {
    return managerDao.update(manager);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return managerDao.delete(no);
  }

  // 이름으로 찾기
  @Override
  public Manager search(String name) throws Exception {
    return managerDao.findByName(name);
  }
}







