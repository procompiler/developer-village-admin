package com.devil.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.devil.dao.CommentDao;
import com.devil.domain.Comment;
import com.devil.domain.User;

@Service
public class DefaultCommentService implements CommentService {
  CommentDao commentDao;

  public DefaultCommentService(CommentDao commentDao) {
    this.commentDao = commentDao;
  }

  @Override
  public int add(Comment comment) throws Exception {
    return commentDao.insert(comment);
  }

  @Override
  public List<Comment> list(String keyword) throws Exception {
    return commentDao.findAll(keyword);
  }

  @Override
  public List<Comment> getByArticleNo(int articleNo) throws Exception {
    return commentDao.findByArticleNo(articleNo);
  }
  @Override
  public Comment get(int no) throws Exception {
    return commentDao.findByNo(no);
  }

  @Override
  public int update(Comment comment) throws Exception {
    return commentDao.update(comment);
  }

  @Override
  public int delete(int no) throws Exception {
    return commentDao.inactive(no);
  }

  @Override
  public List<Comment> listByWriter(User user) throws Exception {
    return commentDao.findByWriter(user);
  }
}
