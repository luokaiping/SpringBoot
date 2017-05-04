package com.demo.webservice;

import com.demo.entity.User;

/**
 * Created by lWX458933 on 2017/4/27.
 */
public class WebUserServiceImpl implements WebUserService {
    @Override
    public User getUser(String id) {
        User user = new User();
        user.setId(id);
        user.setUsername("WebService!");
        return user;
    }
}
