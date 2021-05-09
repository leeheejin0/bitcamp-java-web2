package com.eomcs.asms.service;

import java.util.List;
import com.eomcs.asms.domain.Animal;

public interface AnimalService {

  int add(Animal animal) throws Exception;

  List<Animal> list() throws Exception;

  Animal get(int no) throws Exception;

  int update(Animal animal) throws Exception;

  int delete(int no) throws Exception;

  List<Animal> search(String keyword) throws Exception;
}







