package com.wulang;

import java.util.List;

public class WithList {
    private List<Integer> list;
    private int a;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "WithList{" +
                "list=" + list +
                ", a=" + a +
                '}';
    }
}
