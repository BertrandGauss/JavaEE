package cn.health.server;

import com.alibaba.fastjson.JSONObject;
import cn.health.domain.User_Height_Weight;
import cn.health.mapper.User_Height_WeightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class User_Height_Weight_Service {
    @Autowired
    private User_Height_WeightMapper user_height_weightMapper;

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
            user_height_weightMapper.update_height_weight(user_height_weight.getDate(),user_height_weight.getHeight(),user_height_weight.getWeight());

        }
        JSONObject json = new JSONObject();
        json.put("msg","添加身高体重信息成功");
        json.put("code",0);
        return json;
    }

    public JSONObject selectAllByIdt(Integer id){
        List<User_Height_Weight> user_H_W = user_height_weightMapper.selecttotal(id);
        List<Double> user_bmi = new ArrayList<Double>();
        for(int i=0;i<user_H_W.size();i++){
            Integer height=user_H_W.get(i).getHeight();
            Integer weight=user_H_W.get(i).getWeight();
            Double bmi=(double)weight/((height/1000)^2);
            user_bmi.add(bmi);

        }
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","运动展示");
        json.put("data",user_bmi);
        return json;

    }

}
