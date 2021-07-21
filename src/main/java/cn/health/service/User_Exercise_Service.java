package cn.health.service;

import cn.health.domain.User_Exercise;
import cn.health.domain.UserSport;

import cn.health.mapper.ExerciseInfMapper;
import cn.health.mapper.User_ExerciseMapper;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class User_Exercise_Service {
    @Autowired
    private User_ExerciseMapper user_exerciseMapper;
    @Autowired
    private ExerciseInfMapper exerciseInfMapper;

    //添加或更新今天用户的运动记录
    public JSONObject setTodayExercise(UserSport userSport){

        User_Exercise ue = user_exerciseMapper.selectByIdDate(userSport.getUser_id(),userSport.getExercise_date());

        if(ue==null){ //用户今天没有记录运动
            User_Exercise userE = new User_Exercise();
            userE.setDate(userSport.getExercise_date());
            userE.setUser_id(userSport.getUser_id());
            Integer ca=(int)(userSport.getExercise_time()*exerciseInfMapper.selectByName(userSport.getExercise_name()).getCaloriePerHour());
            userE.setTotal_calorie(ca);
            user_exerciseMapper.add(userE);
        }
        else{
            Integer ca=(int)(ue.getTotal_calorie()+1.0*(userSport.getExercise_time()*exerciseInfMapper.selectByName(userSport.getExercise_name()).getCaloriePerHour()));
            user_exerciseMapper.updatetotal_calorie(ca,userSport.getExercise_date(),userSport.getUser_id());
        }
        JSONObject json = new JSONObject();
        json.put("msg","添加运动成功");
        json.put("code",0);
        return json;
    }

    public JSONObject selectAllById(Integer id){

        List<User_Exercise> user_all_exercise = user_exerciseMapper.selectTotal(id);
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","运动展示");
        json.put("data",user_all_exercise);
        json.put("count",user_all_exercise.size());
        return json;


    }
    
    public JSONObject deleteall(Integer id){
        user_exerciseMapper.deleteall(id);

        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","删除全部记录成功");
        return json;

    }

    public List<User_Exercise> selectByDate(Integer id, Date start, Date end){
        List<User_Exercise> userinfoBydate =user_exerciseMapper.selectByTwoDate(id,start,end);
        return userinfoBydate;

    }

    public  JSONObject deleteOne(Integer id,Date date){
        user_exerciseMapper.deleteone(id,date);
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","删除全部记录成功");
        return json;
    }




}
