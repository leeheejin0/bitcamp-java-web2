package com.eomcs.asms.service.impl;

import java.util.List;
import com.eomcs.asms.dao.AnimalDao;
import com.eomcs.asms.domain.Animal;
import com.eomcs.asms.service.AnimalService;

public class DefaultAnimalService implements AnimalService {

  AnimalDao animalDao; 

  public DefaultAnimalService(AnimalDao animalDao) {
    this.animalDao = animalDao;
  }

  // 게시글 등록 업무
  @Override
  public int add(Animal animal) throws Exception {
    return animalDao.insert(animal);
  }

  // 게시글 목록 조회 업무
  @Override
  public List<Animal> list() throws Exception {
    return animalDao.findByKeyword(null);
  }

  // 게시글 상세 조회 업무
  @Override
  public Animal get(int no) throws Exception {
    Animal animal = animalDao.findByNo(no);
    return animal; 
  }

  // 게시글 변경 업무
  @Override
  public int update(Animal animal) throws Exception {
    return animalDao.update(animal);
  }

  // 게시글 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return animalDao.delete(no);
  }

  // 게시글 검색 업무
  @Override
  public List<Animal> search(String keyword) throws Exception {
    return animalDao.findByKeyword(keyword);
  }
}







