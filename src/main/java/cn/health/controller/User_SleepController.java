package cn.health.controller;

import cn.health.service.User_SleepService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User_SleepController {
    @Autowired
    private User_SleepService user_sleepService;
    //展示用户睡眠时间
    @RequestMapping(value = "/showsleepTime",method = {RequestMethod.GET})
    public JSONObject showSleep(){
        return  user_sleepService.getMonthSleepTime();

    }

}