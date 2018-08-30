package com.wulang.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {
    String addUser(String name) throws RemoteException;
}
