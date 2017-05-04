package com.demo.service;

import com.demo.entity.User;

public interface RMIExService {

    String invokingRemoteService();

    User getUser(String id);
}  