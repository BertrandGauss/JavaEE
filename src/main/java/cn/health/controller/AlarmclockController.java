package cn.health.controller;

import cn.health.domain.Alarmclock;
import cn.health.service.AlarmclockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alarmclock")
public class AlarmclockController {
    @Autowired
    private AlarmclockService alarmclockService;

    //添加警告记录
    @RequestMapping(value = "/addalarmclock",method = {RequestMethod.POST})
    public void addAlarmclock(@RequestBody Alarmclock alarmclock){
        alarmclockService.addAlarmclock(alarmclock);
    }



}
