package com.demo.test;

import com.demo.service.RMIExService;
import org.junit.Test;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * Created by lWX458933 on 2017/4/25.
 */
public class TestRmi {

    @Test
    public void test() {
        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();
        factoryBean.setServiceUrl("rmi://10.142.99.246:1099/rmiService");
        factoryBean.setServiceInterface(RMIExService.class);
        RMIExService service = (RMIExService) factoryBean.getObject();
        System.out.println(service.invokingRemoteService());
    }
}
