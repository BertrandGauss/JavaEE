package cn.health.controller;

import cn.health.domain.Alarmclock;
import cn.health.domain.User_Food;
import cn.health.service.AlarmclockService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/alarmclock")
public class AlarmclockController {
    @Autowired
    private AlarmclockService alarmclockService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    //添加警告记录
    @RequestMapping(value = "/addalarmclock", method = {RequestMethod.POST})
    private JSONObject addAlarmclock(@RequestBody Alarmclock alarmclock) {
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        alarmclock.setUser_id(id);
        alarmclockService.addAlarmclock(alarmclock);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","添加闹钟成功");
        return json;
    }

    @RequestMapping(value = "/showallalarm", method = {RequestMethod.GET})
    private JSONObject showAllAlarm(){
        JSONObject json = new JSONObject();
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        List<Alarmclock> alarmclocks = alarmclockService.showAllAlarm(id);
        json.put("code",0);
        json.put("msg","展示闹钟成功");
        json.put("data",alarmclocks);
        return json;
    }
//    @RequestMapping(value = "/sentalarmclock",method = {RequestMethod.GET})
//    public void sent(){
//        alarmclockService.sendMail();
//    }
}


