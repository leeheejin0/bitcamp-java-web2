package com.eomcs.asms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.eomcs.asms.dao.MemberDao;
import com.eomcs.asms.domain.Member;
import com.eomcs.asms.service.MemberService;

public class DefaultMemberService implements MemberService {

  MemberDao memberDao;

  public DefaultMemberService(MemberDao memberDao) {
    this.memberDao = memberDao;
  }  

  // 등록 업무
  @Override
  public int add(Member member) throws Exception {
    return memberDao.insert(member);
  }

  // 조회 업무
  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }

  // 상세 조회 업무
  @Override
  public Member get(int no) throws Exception {
    return memberDao.findByNo(no);
  }

  // 사용자 조회 업무
  @Override
  public Member get(String email, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);

    return memberDao.findByEmailPassword(params);
  }

  // 변경 업무
  @Override
  public int update(Member member) throws Exception {
    return memberDao.update(member);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return memberDao.delete(no);
  }

  // 이름으로 찾기
  @Override
  public Member search(String name) throws Exception {
    return memberDao.findByName(name);
  }
}







