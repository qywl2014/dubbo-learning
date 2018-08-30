package com.wulang;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

public class MyDubboTest {
    public static void main(String[] args){
        ApplicationConfig applicationConfig=new ApplicationConfig();
        applicationConfig.setName("leo");
        RegistryConfig registryConfig=new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        ReferenceConfig<Hello> referenceConfig=new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(Hello.class);
        Hello hello=referenceConfig.get();
        System.out.println(hello.Hi(1));
    }
}

