package cn.health.service;


import cn.health.domain.Alarmclock;
import cn.health.domain.User_Food;
import cn.health.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//
//import org.apache.commons.httpclient.Header;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.PostMethod;
import java.util.Date;
import java.util.Vector;

@Service
public class AlarmclockService {
    @Autowired
    private AlarmclockMapper alarmclockMapper;
    @Autowired
    private User_FoodMapper user_foodMapper;
    @Autowired
    private User_SleepMapper user_sleepMapper;
    @Autowired
    private User_ExerciseMapper user_exerciseMapper;

    @Scheduled(cron = "0/2 * * * * *")  //没两秒执行一次
    public void timer(){
        //获取当前时间
        LocalDateTime localDateTime =LocalDateTime.now();
        System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    //添加闹钟记录
    public void addAlarmclock(Alarmclock alarmclock){
        alarmclockMapper.add(alarmclock);
    }
//    public
}
