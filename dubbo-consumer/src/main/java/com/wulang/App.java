package com.wulang;

//import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
//    @Reference
//    private Hello hello;
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[] { "classpath*:applicationContext.xml" });
        Hello h= (Hello)applicationContext.getBean("springservice");
        String str=h.Hi();
        System.out.println(str);
    }
}
