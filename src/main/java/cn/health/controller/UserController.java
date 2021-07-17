package cn.health.controller;

import  cn.health.domain.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import cn.health.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    //注册
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    private JSONObject register(@RequestBody User user){
        JSONObject json = new JSONObject();
        json= userService.register(user);
        System.out.println("注册成功");
        return json;
    }

    //登录
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    private JSONObject login(@RequestBody User user){
        System.out.print("登录");
        JSONObject json = new JSONObject();
        json= userService.login(user);
        //将登录凭证加入到用户登录成功的Session类
        this.httpServletRequest.getSession().setAttribute("LOGIN",true);
        //保存用户id在session
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userService.phoneisregister(user.getTelephone()));
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        this.httpServletRequest.getSession().setAttribute("LOGIN_NAME", userService.selectNameById(id));

        System.out.println("get"+id);
        System.out.println("sessionId"+httpServletRequest.getSession().getId());
        return json;
    }
    //忘记密码
    @RequestMapping(value = "/forget",method = {RequestMethod.POST})
    private JSONObject forgetpassword(@RequestBody User user){
        System.out.println("登录");
        JSONObject json = new JSONObject();
        json= userService.login(user);

        //将登录凭证加入到用户登录成功的Session类
        httpServletRequest.getSession().setAttribute("LOGIN",true);
        //保存用户id在session
        httpServletRequest.getSession().setAttribute("LOGIN_USER", userService.phoneisregister(user.getTelephone()));

        return json;
    }






}
