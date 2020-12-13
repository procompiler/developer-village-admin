package com.devil.domain;

import java.util.Date;

public class Badge {
  private int no;
  private String name;
  private String photo;
  private int tagNo;
  private int state; // 활성상태 0 안보임 1 보임
  private String content;
  private Date collectDate;

  public int getState() {
    return state;
  }

  public Badge setState(int state) {
    this.state = state;
    return this;
  }

  public int getNo() {
    return no;
  }

  public Badge setNo(int no) {
    this.no = no;
    return this;
  }

  public String getName() {
    return name;
  }

  public Badge setName(String name) {
    this.name = name;
    return this;
  }

  public String getPhoto() {
    return photo;
  }

  public Badge setPhoto(String photo) {
    this.photo = photo;
    return this;
  }

  public int getTagNo() {
    return tagNo;
  }

  public Badge setTagNo(int tagNo) {
    this.tagNo = tagNo;
    return this;
  }

  public String getContent() {
    return content;
  }

  public Badge setContent(String content) {
    this.content = content;
    return this;
  }

  public Date getCollectDate() {
    return collectDate;
  }

  public void setCollectDate(Date collectDate) {
    this.collectDate = collectDate;
  }

}
