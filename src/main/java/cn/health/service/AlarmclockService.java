package cn.health.service;


import cn.health.domain.Alarmclock;
import cn.health.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.*;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.*;

@Service

public class AlarmclockService {

    @Autowired
    private AlarmclockMapper alarmclockMapper;
    @Autowired
    private UserMapper userMapper;


    @Value("${spring.mail.username}")
    private String whoAmI;
//
    @Autowired
    private JavaMailSenderImpl mailSender;

    //添加闹钟记录
    public void addAlarmclock(Alarmclock alarmclock){
        alarmclockMapper.add(alarmclock);
    }

    //按时间发送邮件
    @Scheduled(cron = "0 */1 * * * ?")  //每1分钟执行一次
    public void sendMail(){

        LocalDate localDate=LocalDate.now();  // 获取当前日期 format: yyyy-MM-dd
        LocalTime localTime=LocalTime.now();  // 获取当前时间 format: HH:mm:ss
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        Instant instant1 = zonedDateTime.toInstant();
        Date now = Date.from(instant1);

        List<Alarmclock> clocks=alarmclockMapper.selectByDate(now);
        for (int i=0;i<clocks.size();i++){
            Alarmclock clock=clocks.get(i);
            if(clock.getTime().toLocalTime().getHour()==localTime.getHour()&&clock.getTime().toLocalTime().getMinute()==localTime.getMinute()){
                sendSimpleMail(clock);
            }
        }
    }

    //发邮件
    public void sendSimpleMail(Alarmclock alarmclock) {
        System.out.print("发送邮件----》");
        SimpleMailMessage message = new SimpleMailMessage();
        String email = userMapper.selectEmailByID(alarmclock.getUser_id());
        String content="尊敬的"+userMapper.selectnameByID(alarmclock.getUser_id())+"用户，您好。您设置的"+alarmclock.getName()+"时间已到，请及时"+alarmclock.getName()+"。";
        message.setTo(email);
        //添加抄送人，防止邮件发送失败
        message.setCc(whoAmI);
        message.setSubject("健康管理系统提醒");
        message.setText(content);
        message.setFrom(whoAmI);
        mailSender.send(message);
    }

    public List<Alarmclock> showAllAlarm(Integer id){
        List<Alarmclock> alarmclocks=alarmclockMapper.selectALLByID(id);
        return alarmclocks;
    }


}
