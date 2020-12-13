package com.devil.dao;

import java.util.List;
import com.devil.domain.Block;
import com.devil.domain.Report;

public interface ReportDao {
  public int insert(Report report) throws Exception;
  public int insertReportedArticle(Report reportedArticle) throws Exception;
  public int insertReportedComment(Report reportedComment) throws Exception;
  public List<Report> findAll(String keyword) throws Exception;
  public int delete(int no) throws Exception;
  public Report findByNo(int no) throws Exception;
  public int insertStatus(Block block) throws Exception;
}
