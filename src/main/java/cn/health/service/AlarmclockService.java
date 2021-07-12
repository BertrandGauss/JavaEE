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
    @Autowired
    private UserMapper userMapper;
    //分析用户今日的饮食以及推荐摄入食物
    public String analize(Integer id, Date date){
        String word="";

        User_Food user_food=user_foodMapper.selectByIdDate(id,date);
        Vector<String> lack=new Vector<String >();
        if(user_food.getTotal_vitaminA()<0.8){
            lack.add("维生素A");
        }
        if(user_food.getTotal_vitaminB()<1){
            lack.add("维生素B");
        }
        if(user_food.getTotal_vitaminC()<75){
            lack.add("维生素C");
        }
        if(user_food.getTotal_vitaminD()<0.005){
            lack.add("维生素D");
        }
        if(user_food.getTotal_vitaminE()<12){
            lack.add("维生素D");
        }
        if(user_food.getTotal_fat()<100){
            lack.add("脂肪");
        }
        if(user_food.getTotal_protein()<80){
            lack.add("蛋白质");
        }
        if(user_food.getTotal_carbs()<300){
            lack.add("碳水化合物");
        }
        if(lack.size()==0){
            word=userMapper.selectnameByID(user_food.getUser_id())+"您今日各类营养成分摄入充分，请您明天继续保持";
        }
        else{

        }
        return word;


    }

//    public
}
