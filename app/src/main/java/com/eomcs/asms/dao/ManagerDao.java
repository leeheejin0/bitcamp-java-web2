package com.eomcs.asms.dao;

import java.util.List;
import java.util.Map;
import com.eomcs.asms.domain.Manager;

public interface ManagerDao {

  int insert(Manager manager) throws Exception;

  List<Manager> findAll() throws Exception;

  Manager findByNo(int no) throws Exception;

  Manager findByEmailPassword(Map<String,Object> params) throws Exception;

  int update(Manager manager) throws Exception;

  int delete(int no) throws Exception;

  Manager findByName(String name) throws Exception;
}












