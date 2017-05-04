package com.demo.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.demo.service.UserService;

import java.net.MalformedURLException;

/**
 * Created by lWX458933 on 2017/4/19.
 */
public class TestHessian {
    public static void main(String[] args) {
        String url = "http://localhost:8011/WebUserService";
        HessianProxyFactory factory = new HessianProxyFactory();
        try {
            UserService userService = (UserService) factory.create(UserService.class, url);
            System.out.println(userService.get("123"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
