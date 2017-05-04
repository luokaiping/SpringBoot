package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import com.demo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ComponentScan
@Configuration
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserService userService;

    @RequestMapping("/{id}")
    public User getUser(@PathVariable String id) {
        User user = userService.get(id);
        log.info(user.toString());
        return user;
    }

    @RequestMapping("/getAll")
    public List<User> getAll() {
        List<User> userList = userService.getAll();
        log.info(JsonUtil.toJsonString(userList));
        return userList;
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        int result = userService.delete(id);
        log.info("Exec Result:"+result);
    }

    @RequestMapping("/update/{id}")
    public void update(@PathVariable String id) {
        User user = new User();
        user.setUsername(Math.random()+"");
        user.setId(id);
        int result = userService.update(user);
        log.info("Exec Result:"+result);
    }

    @RequestMapping("/save")
    public void save() {
        User user = new User();
        user.setUsername(Math.random()+"");
        int result = userService.save(user);
        log.info("Exec Result:"+result);
    }
}