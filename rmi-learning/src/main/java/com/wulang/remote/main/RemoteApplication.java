package com.wulang.remote.main;

import com.wulang.api.UserService;
import com.wulang.remote.UserServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RemoteApplication {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(6666);
            UserService userService=new UserServiceImpl();
//            Naming.rebind("rmi://192.168.25.128:6666/userService",userService);
            Naming.rebind("rmi://127.0.0.1:6666/a",userService);
//            while (true){}
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

