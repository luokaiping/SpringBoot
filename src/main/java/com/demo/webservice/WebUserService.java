package com.demo.webservice;

import com.demo.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by lWX458933 on 2017/4/27.
 */
@WebService
public interface WebUserService {

    @WebMethod
    User getUser(String id);

}
