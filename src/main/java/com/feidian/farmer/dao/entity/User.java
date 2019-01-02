package com.feidian.farmer.dao.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    // 用户名
    String username;

    // 密码
    String password;

    // 用户类型
    Short userType;

    // 用户可用菜单
    String menu;

}
