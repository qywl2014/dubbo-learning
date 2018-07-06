package com.wulang.test;

import com.wulang.annotation.Table;
import com.wulang.entity.User;

public class AnnotationTest {
    public static void main(String[] args) {
        User user=new User();
        user.setName("wulang");
        Class c=user.getClass();
        if(c.isAnnotationPresent(Table.class)){
            Table table=(Table) c.getAnnotation(Table.class);
            System.out.println(table.value());
        }
    }
}

