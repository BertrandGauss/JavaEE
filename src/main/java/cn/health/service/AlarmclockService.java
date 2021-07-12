package cn.health.service;


import cn.health.domain.User_Food;
import cn.health.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


//    public
}
