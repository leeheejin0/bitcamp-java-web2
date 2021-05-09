package com.eomcs.asms.dao;

import java.util.List;
import com.eomcs.asms.domain.Animal;

// BoardDao 의 규칙 정의
public interface AnimalDao {

  int insert(Animal animal) throws Exception;

  List<Animal> findByKeyword(String keyword) throws Exception;

  Animal findByNo(int no) throws Exception;

  int update(Animal animal) throws Exception;

  int delete(int no) throws Exception;
}












