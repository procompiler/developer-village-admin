package com.devil.service;

import java.util.List;
import com.devil.domain.Tag;
import com.devil.domain.User;

public interface TagService {
  int add(Tag tag) throws Exception;
  List<Tag> list(String keyword) throws Exception;
  Tag get(int no) throws Exception;
  int update(Tag tag) throws Exception;
  int delete(int no) throws Exception;
  List<Tag> list(User user) throws Exception;
}