package cn.health.service;

import cn.health.domain.User_Sleep;
import cn.health.mapper.User_SleepMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_SleepService {
    @Autowired
    private User_SleepMapper user_sleepMapper;

    public JSONObject addSleepTime(User_Sleep user_sleep){
        user_sleepMapper.add(user_sleep);
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","睡眠记录添加成功");
        return json;

    }
    public JSONObject getMonthSleepTime(){
        JSONObject json=new JSONObject();
        List<User_Sleep> sleepList=user_sleepMapper.select30();
        json.put("code",0);
        json.put("msg","睡眠展示");
        json.put("data",sleepList);
        return  json;

    }


}
