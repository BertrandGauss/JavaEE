package cn.health.controller;

import cn.health.domain.DateRange;
import cn.health.domain.SomeDate;
import cn.health.domain.User_Sleep;
import cn.health.service.User_SleepService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    //删除部分睡眠记录
    @RequestMapping(value = "/deleteSomesleep",method = {RequestMethod.POST})
    private JSONObject deleteSomesleep(@RequestBody SomeDate someDate){
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_sleepService.deleteSomeSleep(id,someDate.getDates());
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","删除部分睡眠记录成功");
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
    
    @RequestMapping(value = "/selectbydate",method = {RequestMethod.POST})
    private JSONObject selectByDate(@RequestBody DateRange dateRange){

        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");

        List<User_Sleep> user_date_info = user_sleepService.selectByDate(id,dateRange.getStartdate(),dateRange.getEnddate());
        JSONObject json = new JSONObject();

        json.put("code",0);
        json.put("data",user_date_info);
        json.put("msg","查看部分信息成功");

        return json;

    }

}


