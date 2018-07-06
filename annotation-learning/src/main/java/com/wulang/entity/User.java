package com.wulang.entity;

import com.wulang.annotation.Table;

@Table("user")
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

