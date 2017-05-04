package com.demo.service.impl;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lWX458933 on 2017/4/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserMapper userMapper;

    @Override
    @CachePut(value = "User", key = "#user.id")
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    @Cacheable(value = "User", key = "#id")
    public User get(String id) {
        return userMapper.get(id);
    }

    @Override
    @CacheEvict(value = "User")
    public int delete(String id) {
        return userMapper.delete(id);
    }

    @Override
    @CachePut(value = "User", key = "#user.id")
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    @Cacheable("UserList")
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
