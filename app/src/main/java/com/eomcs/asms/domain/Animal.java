package com.eomcs.asms.domain;

import java.sql.Date;

public class Animal {
  private int no;
  private Manager writer;
  private String asName;
  private int speciesNo;
  private String species;
  private String photo;
  private String breed;
  private int gender;
  private String age;
  private Date registeredDate;
  private String place;
  private String tel;
  private int status;
  @Override
  public String toString() {
    return "Animal [no=" + no + ", writer=" + writer + ", asName=" + asName + ", speciesNo="
        + speciesNo + ", species=" + species + ", photo=" + photo + ", breed=" + breed + ", gender="
        + gender + ", age=" + age + ", registeredDate=" + registeredDate + ", place=" + place
        + ", tel=" + tel + ", status=" + status + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public Manager getWriter() {
    return writer;
  }
  public void setWriter(Manager writer) {
    this.writer = writer;
  }
  public String getAsName() {
    return asName;
  }
  public void setAsName(String asName) {
    this.asName = asName;
  }
  public int getSpeciesNo() {
    return speciesNo;
  }
  public void setSpeciesNo(int speciesNo) {
    this.speciesNo = speciesNo;
  }
  public String getSpecies() {
    return species;
  }
  public void setSpecies(String species) {
    this.species = species;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public String getBreed() {
    return breed;
  }
  public void setBreed(String breed) {
    this.breed = breed;
  }
  public int getGender() {
    return gender;
  }
  public void setGender(int gender) {
    this.gender = gender;
  }
  public String getAge() {
    return age;
  }
  public void setAge(String age) {
    this.age = age;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public String getPlace() {
    return place;
  }
  public void setPlace(String place) {
    this.place = place;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }

}
