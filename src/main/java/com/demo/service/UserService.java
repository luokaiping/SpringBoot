package com.demo.service;

import com.demo.entity.User;

import java.util.List;

/**
 * Created by lWX458933 on 2017/4/19.
 */
public interface UserService {
    int save(User user);

    User get(String id);

    int delete(String id);

    int update(User user);

    List<User> getAll();
}
