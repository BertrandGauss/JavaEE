package cn.health.controller;

import cn.health.server.User_sleepServer;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User_sleepController {
    @Autowired
    private User_sleepServer user_sleepServer;

//    @RequestMapping(value = "/showfood",method = {RequestMethod.GET})
//    public JSONObject showSleep(){
//
//    }
}
