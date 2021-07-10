package cn.health.controller;

import  cn.health.domain.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import cn.health.server.UserServer;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServer userServer;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    private JSONObject register(@RequestBody User user){
        JSONObject json = new JSONObject();
        json=userServer.register(user);
        System.out.println("注册成功");
        return json;
    }

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    private JSONObject login(@RequestBody User user){
        System.out.print("登录");
        JSONObject json = new JSONObject();
        json=userServer.login(user);
        //将登录凭证加入到用户登录成功的Session类
        this.httpServletRequest.getSession().setAttribute("LOGIN",true);
        //保存用户id在session
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER",userServer.isregister(user.getTelephone()));

        return json;
    }






}
