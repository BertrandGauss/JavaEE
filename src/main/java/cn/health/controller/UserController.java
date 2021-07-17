package cn.health.controller;

import  cn.health.domain.User;
import cn.health.domain.User_Calorie;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import cn.health.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    
    
    @RequestMapping(value = "/getusername",method = {RequestMethod.GET})
    private JSONObject getUserName(){

        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        String user_name=userService.selectNameById(id);

        JSONObject json = new JSONObject();

        json.put("code",0);
        json.put("data",user_name);
        json.put("msg","返回用户名成功");
        
       
        return json;
    }
    
    
    @RequestMapping(value = "/updateinfo",method = {RequestMethod.POST})
    private JSONObject updateInfo(@RequestBody User user){

        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user.setUser_id(id);
        
        userService.updateinfo(user);

        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","更新用户信息成功");


        return json;
    }

    @RequestMapping(value = "/showallinfo",method = {RequestMethod.GET})
    private JSONObject showAllInfo(){

        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");

        User userinfo = userService.showuserinfo(id);

        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("data",userinfo);
        json.put("msg","返回用户信息成功");
        return json;
    }
    
    @RequestMapping(value = "/showallcalorie",method = {RequestMethod.GET})
    private JSONObject showAllCalorie(){

        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");

        List<User_Calorie> userca = userService.selectCaById(id);

        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("data",userca);
        json.put("msg","返回卡路里信息成功");
        return json;
    }
    






}
