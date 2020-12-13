package com.devil.domain;

import java.sql.Date;

public class Block {
  private int no;
  private User reportedUser;
  private Date permittedDate;
  private int blockedDates;
  private String blockedReason;
  private String unBlockedReason;
  private Report report;

  public int getNo() {
    return no;
  }
  public Block setNo(int no) {
    this.no = no;
    return this;
  }
  public User getReportedUser() {
    return reportedUser;
  }
  public Block setReportedUser(User reportedUser) {
    this.reportedUser = reportedUser;
    return this;
  }
  public Date getPermittedDate() {
    return permittedDate;
  }
  public Block setPermittedDate(Date permittedDate) {
    this.permittedDate = permittedDate;
    return this;
  }
  public int getBlockedDates() {
    return blockedDates;
  }
  public Block setBlockedDates(int blockedDates) {
    this.blockedDates = blockedDates;
    return this;
  }
  public String getBlockedReason() {
    return blockedReason;
  }
  public Block setBlockedReason(String blockedReason) {
    this.blockedReason = blockedReason;
    return this;
  }
  public String getUnBlockedReason() {
    return unBlockedReason;
  }
  public Block setUnBlockedReason(String unBlockedReason) {
    this.unBlockedReason = unBlockedReason;
    return this;
  }
  public Report getReport() {
    return report;
  }
  public Block setReport(Report report) {
    this.report = report;
    return this;
  }
}
