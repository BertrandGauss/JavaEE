package cn.health.controller;

import cn.health.domain.Alarmclock;
import cn.health.service.AlarmclockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/alarmclock")
public class AlarmclockController {
    @Autowired
    private AlarmclockService alarmclockService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    //添加警告记录
    @RequestMapping(value = "/addalarmclock", method = {RequestMethod.POST})
    private void addAlarmclock(@RequestBody Alarmclock alarmclock) {
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        alarmclock.setUser_id(id);
        alarmclockService.addAlarmclock(alarmclock);
    }


//    @RequestMapping(value = "/sentalarmclock",method = {RequestMethod.GET})
//    public void sent(){
//        alarmclockService.sendMail();
//    }
}


