package com.feidian.farmer.dao.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用戶实体
 */


public class User {

    // 用户名
    private String username;

    // 密码
    private String password;

    // 用户类型
    private Short userType;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
