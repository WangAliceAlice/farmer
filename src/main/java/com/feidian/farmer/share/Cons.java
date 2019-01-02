package com.feidian.farmer.share;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Cons {

    // admin 用户类型
    public static short USER_TYPE_ADMIN = 1;

    // 技术员
    public static short USER_TYPE_TECH = 2;

    // 市场人员
    public static short USER_TYPE_MARKET = 3;

    // 游客
    public static short USER_TYPE_GUEST = 4;


    public static String getMenuByType(short userType) {

        List<Menu> menuList = new ArrayList<>();

        menuList.add(new Menu("生产材料", "/"));
        menuList.add(new Menu("配肥配药", "/"));
        menuList.add(new Menu("生产计划", "/"));
        menuList.add(new Menu("农作信息", "/"));
        menuList.add(new Menu("实际采收", "/"));
        menuList.add(new Menu("提醒管理", "/"));

        System.out.println(menuList.toString());
        return JSON.toJSONString(menuList);
    }

    @AllArgsConstructor
    static class Menu {

        String name;

        String url;

    }

}
