package com.wulang;

public class HelloImpl implements Hello{
    @Override
    public String Hi(){
        System.out.println("hello node");
        return "I am provider";
    }
}
