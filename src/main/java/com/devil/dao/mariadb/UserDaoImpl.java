package com.devil.dao.mariadb;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import com.devil.dao.UserDao;
import com.devil.domain.Block;
import com.devil.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

  SqlSessionFactory sqlSessionFactory;

  public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int insert(User user) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("UserDao.insert", user);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("UserDao.delete", no);
    }
  }

  @Override
  public User findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("UserDao.findByNo", no);
    }
  }

  @Override
  public List<User> findByName(String name) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      List<User> users = sqlSession.selectList("UserDao.findByName", name);
      return users;
    }
  }

  @Override
  public List<User> findAll(String keyword) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("UserDao.findAll", keyword);
    }
  }

  @Override
  public int update(User user) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("UserDao.update", user);
    }
  }

  @Override
  public User findByEmailPassword(String email, String password) throws Exception {
    HashMap<String,Object> map = new HashMap<>();
    map.put("email", email);
    map.put("password", password);

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("UserDao.findByEmailPassword", map);
    }
  }

  @Override
  public int inactive(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("UserDao.inactive", no);
    }
  }

  @Override
  public int insertBlocked(Block block) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("UserDao.insertBlocked", block);
    }
  }

  @Override
  public List<User> findByFollower(User user) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("UserDao.findByFollower", user);
    }
  }

  @Override
  public List<User> findFollower(User user) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("UserDao.findFollower", user);
    }
  }

}
