package com.wulang.remote;

import com.wulang.api.UserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    public UserServiceImpl() throws RemoteException {

    }

    @Override
    public String addUser(String name) throws RemoteException{
        return name+" I am remote";
    }
}

