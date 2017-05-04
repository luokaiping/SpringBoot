package com.demo;

import com.demo.service.RMIExService;
import com.demo.service.UserService;
import com.demo.service.impl.RMIExServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import javax.annotation.Resource;

/**
 * Created by lWX458933 on 2017/4/19.
 */
@SpringBootApplication
@ImportResource(value = {"classpath:providers.xml"})
@MapperScan("com.demo.mapper")
@EntityScan("com.demo.entity")
@ServletComponentScan
public class Application {

    @Autowired
    private UserService userService;

    @Resource
    private RMIExServiceImpl rmiExServiceImpl;

    public static void main(String[] args) {
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "5865");
        SpringApplication.run(Application.class, args);
    }

    /*@Bean
    public EmbeddedServletContainerFactory servletFactory() {
        TomcatEmbeddedServletContainerFactory tomcatFactory =
                new TomcatEmbeddedServletContainerFactory();
        tomcatFactory.setPort(8012);
        tomcatFactory.setSessionTimeout(10, TimeUnit.SECONDS);
        return tomcatFactory;

    }*/

    @Bean("/userService")
    public HessianServiceExporter exporterUserService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(userService);
        exporter.setServiceInterface(UserService.class);
        return exporter;
    }

    @Bean("/rmiService")
    public RmiServiceExporter initRmiServiceExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(RMIExService.class);
        exporter.setServiceName("rmiService");
        exporter.setService(rmiExServiceImpl);
        return exporter;
    }

}
