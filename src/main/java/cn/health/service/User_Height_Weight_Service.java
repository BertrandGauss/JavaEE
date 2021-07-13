package cn.health.service;

import cn.health.domain.User;
import cn.health.mapper.UserMapper;
import com.alibaba.fastjson.JSONObject;
import cn.health.domain.User_Height_Weight;
import cn.health.mapper.User_Height_WeightMapper;
import javafx.util.Pair;
import org.apache.ibatis.annotations.Param;
import cn.health.util.GetAgeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class User_Height_Weight_Service {
    @Autowired
    private User_Height_WeightMapper user_height_weightMapper;
    @Autowired
    private UserMapper userMapper;

    public JSONObject SetHeightWeight(User_Height_Weight user_height_weight){
        User_Height_Weight uhw = user_height_weightMapper.selectByIdDate(user_height_weight.getUser_id(),user_height_weight.getDate());
        if(uhw==null){
            User_Height_Weight uHW = new User_Height_Weight();
            uHW.setUser_id(user_height_weight.getUser_id());
            uHW.setDate(user_height_weight.getDate());
            uHW.setHeight(user_height_weight.getHeight());
            uHW.setWeight(user_height_weight.getWeight());
            user_height_weightMapper.add(uHW);


        }
        else{
            user_height_weightMapper.update_height_weight(user_height_weight.getUser_id(),user_height_weight.getDate(),user_height_weight.getHeight(),user_height_weight.getWeight());

        }
        JSONObject json = new JSONObject();
        json.put("msg","添加身高体重信息成功");
        json.put("code",0);
        return json;
    }

    public JSONObject selectAllByIdt(Integer id){
        Date birth= userMapper.selectbirthByID(id);
        List<User_Height_Weight> user_H_W = user_height_weightMapper.selecttotal(id);
        List< Pair<Double,Double> > user_BmiandTizhi = new ArrayList<Pair<Double,Double>>();
        for(int i=0;i<user_H_W.size();i++){
            Integer height=user_H_W.get(i).getHeight();
            Integer weight=user_H_W.get(i).getWeight();
            Double bmi=(double)weight/((height/1000)^2);
            int mark=0;
            if(userMapper.findgenderByID(id).equals("male")){
                mark=1;
            }
            Double tizhi=(double)1.2*bmi+0.23*GetAgeUtil.getAge(birth)-5.4-10.8*mark;
            Pair<Double,Double> p=new Pair<Double,Double>(bmi,tizhi);
            user_BmiandTizhi.add(p);
        }
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","BMI和体脂展示");
        json.put("data",user_BmiandTizhi);
        return json;

    }

}
