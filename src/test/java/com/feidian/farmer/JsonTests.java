package com.feidian.farmer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonTests {

    @Test
    public void testJson() {
        List<String> menu = new ArrayList<>();
        menu.add("土地管理");
        menu.add("生产材料");
        menu.add("配肥和配药");
        menu.add("生产计划");
        menu.add("农作信息");
        menu.add("实际采收");
        menu.add("提醒管理");
        System.out.println(JSON.toJSONString(menu));
    }

}
