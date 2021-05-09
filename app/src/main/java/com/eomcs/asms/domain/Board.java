package com.eomcs.asms.domain;

import java.sql.Date;

public class Board {
  private int no;
  private Member writer;
  private String title;
  private String content;
  private Date registeredDate;
  private int viewCount;
  private int like;
  private String file;

  @Override
  public String toString() {
    return "Board [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content
        + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount + ", like=" + like
        + ", file=" + file + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getLike() {
    return like;
  }
  public void setLike(int like) {
    this.like = like;
  }
  public String getFile() {
    return file;
  }
  public void setFile(String file) {
    this.file = file;
  }


}
