package com.wulang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] arg){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"classpath*:applicationContext.xml" });
//        while(true);
    }
}
