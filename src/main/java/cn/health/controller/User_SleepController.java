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
    private JSONObject showSleep(){
        return  user_sleepService.getMonthSleepTime();
    }

    //增加睡眠记录
    @RequestMapping(value = "/addsleepTime",method = {RequestMethod.POST})
    private JSONObject addSleep(@RequestBody User_Sleep user_sleep){

        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_sleep.setUser_id(id);
        return  user_sleepService.addSleepTime(user_sleep);
    }

    //更新睡眠记录
    @RequestMapping(value = "/updatesleepTime", method = {RequestMethod.POST})
    private JSONObject updateSleep(@RequestBody User_Sleep user_sleep){
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_sleep.setUser_id(id);
        System.out.println(user_sleep.getDate()+" "+user_sleep.getSleeptime()+" "+user_sleep.getStarttime());
        user_sleepService.updateSleepTime(user_sleep);
        JSONObject json = new JSONObject( );
        json.put("code",0);
        json.put("msg","更新睡眠记录成功");
        return json;

    }

    //删除全部睡眠记录
    @RequestMapping(value = "/deleteALLsleep",method = {RequestMethod.GET})
    private JSONObject deleteALLsleep(){
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_sleepService.deleteALL(id);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","删除全部睡眠记录成功");
        return json;
    }

    //删除单条睡眠记录
    @RequestMapping(value = "/deleteOnesleep",method = {RequestMethod.POST})
    private JSONObject deleteOnesleep(@RequestBody User_Sleep user_sleep){
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_sleepService.deleteOne(user_sleep.getDate(),id);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","删除单条睡眠记录成功");
        return json;

    }
}
