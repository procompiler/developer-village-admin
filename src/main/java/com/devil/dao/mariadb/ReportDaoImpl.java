package com.devil.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.devil.dao.ReportDao;
import com.devil.domain.Block;
import com.devil.domain.Report;

@Repository
public class ReportDaoImpl implements ReportDao {

  SqlSessionFactory sqlSessionFactory;

  public ReportDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int insert(Report report) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("ReportDao.insert", report);
    }
  }

  @Override
  public int insertReportedArticle(Report reportedArticle) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("ReportDao.insertReportedArticle", reportedArticle);
    }
  }

  @Override
  public int insertReportedComment(Report reportedComment) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("ReportDao.insertReportedComment", reportedComment);
    }
  }

  @Override
  public int insertStatus(Block block) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("ReportDao.insertStatus", block);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("ReportDao.delete", no);
    }
  }

  @Override
  public List<Report> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("ReportDao.findAll", keyword);
    }
  }

  @Override
  public Report findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("ReportDao.findByNo", no);
    }
  }


}
