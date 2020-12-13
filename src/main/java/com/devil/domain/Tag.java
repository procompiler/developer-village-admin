package com.devil.domain;

public class Tag {
  private int no;
  private String name;
  private String photo;
  private String tagColor;
  private String fontColor;
  private int state; // 활성상태 0 안보임 1 보임

  public int getNo() {
    return no;
  }
  public Tag setNo(int no) {
    this.no = no;
    return this;
  }
  public String getName() {
    return name;
  }
  public Tag setName(String name) {
    this.name = name;
    return this;
  }
  public String getPhoto() {
    return photo;
  }
  public Tag setPhoto(String photo) {
    this.photo = photo;
    return this;
  }
  public String getTagColor() {
    return tagColor;
  }
  public Tag setTagColor(String tagColor) {
    this.tagColor = tagColor;
    return this;
  }
  public String getFontColor() {
    return fontColor;
  }
  public Tag setFontColor(String fontColor) {
    this.fontColor = fontColor;
    return this;
  }
  public int getState() {
    return state;
  }
  public void setState(int state) {
    this.state = state;
  }
}
