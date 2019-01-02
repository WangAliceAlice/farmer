package com.feidian.farmer.controller;

import com.alibaba.fastjson.JSONObject;
import com.feidian.farmer.dao.entity.User;
import com.feidian.farmer.service.UserService;
import com.feidian.farmer.share.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    private final UserService userService;

    private final String USERNAME = "username";

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login_p", method = RequestMethod.POST)
    public ResponseBean login(@RequestBody String data, HttpSession session) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String username = jsonObject.getJSONObject("data").getString("username");
        String password = jsonObject.getJSONObject("data").getString("password");
        if ("guest".equals(username)) {
            session.setAttribute(USERNAME, username);
            return ResponseBean.ok("success");
        }

        User user = userService.getOne(username);

        if (user == null) {
            return ResponseBean.error("No such user!");
        }
        if (user.getPassword().equals(password)) {
            session.setAttribute(USERNAME, username);
            return ResponseBean.ok("success");
        }

        return ResponseBean.error("Wrong password!");
    }


    @RequestMapping(value = "/initUser", method = RequestMethod.GET)
    public ResponseBean initUser(HttpSession session) {
        String username = (String) session.getAttribute(USERNAME);
        if (null == username || "".equals(username)) {
            return ResponseBean.error("Please login first!");
        }
        return ResponseBean.ok("success", userService.getOne(username));
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpSession session) {
        session.removeAttribute(USERNAME);
    }

}
