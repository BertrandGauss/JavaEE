package cn.health.controller;

import  cn.health.domain.User;
import  cn.health.mapper.UserMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.health.server.UserServer;
import cn.health.util.CookieUtil;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServer userServer;

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
        //5、生成uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //6、创建cookie,客户端保存cookie
//        CookieUtil.setCookie(response, CookieConstant.TOKEN,uuid);
////        //7、把用户信息存入redis
////        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN,uuid),user);
////        //8、设置过期时间
////        redisTemplate.expire(String.format(RedisConstant.TOKEN,uuid), RedisConstant.EXPIRE, TimeUnit.SECONDS);

        return json;
    }






}
