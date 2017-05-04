package com.demo.service.impl;

import com.demo.service.DubboService;

/**
 * Created by lWX458933 on 2017/4/27.
 */
public class DubboServiceImpl implements DubboService {
    @Override
    public String invokeDubbo(String exampleName){
        return "Dubbo: "+exampleName;
    }
}
