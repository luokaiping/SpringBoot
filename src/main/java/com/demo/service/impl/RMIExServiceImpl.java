package com.demo.service.impl;

import com.demo.entity.User;
import com.demo.service.RMIExService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service(value = "rmiExServiceImpl")
public class RMIExServiceImpl implements RMIExService {

    @PostConstruct
    public void initMethod() {
    }

    @Override
    public String invokingRemoteService() {
        // TODO Auto-generated method stub  
        String result = "欢迎你调用远程接口";
        return result;
    }

    @Override
    public User getUser(String id) {
        User user = new User();
        user.setId(id);
        user.setUsername("This is name！");
        return user;
    }
}