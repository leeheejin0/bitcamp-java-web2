package com.eomcs.asms.service;

import java.util.List;
import com.eomcs.asms.domain.Manager;

public interface ManagerService {

  int add(Manager manager) throws Exception;

  List<Manager> list() throws Exception;

  Manager get(int no) throws Exception;

  Manager get(String email, String password) throws Exception;

  int update(Manager manager) throws Exception;

  int delete(int no) throws Exception;

  Manager search(String name) throws Exception;
}







