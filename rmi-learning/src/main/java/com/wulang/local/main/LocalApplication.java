package com.wulang.local.main;

import com.wulang.api.UserService;
import sun.rmi.server.Util;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LocalApplication {
    public static void main(String[] args) {
        try {
            System.out.println("1");
//            UserService userService=(UserService) Naming.lookup("rmi://192.168.25.128:6666/userService");
            UserService userService=(UserService) Naming.lookup("rmi://127.0.0.1:6666/a");
            System.out.println(userService.addUser("hello rmi,I am local"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

