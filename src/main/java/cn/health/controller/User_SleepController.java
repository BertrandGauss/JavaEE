package cn.health.controller;

import cn.health.domain.User_Sleep;
import cn.health.service.User_SleepService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sleep")
public class User_SleepController {
    @Autowired
    private User_SleepService user_sleepService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    //展示用户睡眠时间
    @RequestMapping(value = "/showsleepTime",method = {RequestMethod.GET})
    public JSONObject showSleep(){
        return  user_sleepService.getMonthSleepTime();
    }
    //增加睡眠记录
    @RequestMapping(value = "/addsleepTime",method = {RequestMethod.POST})
    public JSONObject addSleep(@RequestBody User_Sleep user_sleep){

        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_sleep.setUser_id(id);
        return  user_sleepService.addSleepTime(user_sleep);
    }

}
