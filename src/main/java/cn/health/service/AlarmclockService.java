package cn.health.service;


import cn.health.domain.User_Food;
import cn.health.mapper.AlarmclockMapper;
import cn.health.mapper.User_ExerciseMapper;
import cn.health.mapper.User_FoodMapper;
import cn.health.mapper.User_SleepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    //分析用户今日的饮食以及
    public String analize(Integer id, Date date){
        String word="";

        User_Food user_food=user_foodMapper.selectByIdDate(id,date);
        //if(user_food.getTotal_vitaminA()<)
        return word;


    }

//    public
}
