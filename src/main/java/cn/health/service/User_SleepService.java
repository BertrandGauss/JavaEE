package cn.health.service;

import cn.health.domain.User_Sleep;
import cn.health.mapper.User_SleepMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public void updateSleepTime(User_Sleep user_sleep){
        user_sleepMapper.update(user_sleep);

    }

    public void deleteALL(Integer id){
        user_sleepMapper.deleteALL(id);
    }

    public  void deleteOne(Date date , Integer id ){
        user_sleepMapper.deleteOne(date,id);
    }
    
    public List<User_Sleep> selectByDate(Integer id, Date start, Date end){
        List<User_Sleep> userinfoBydate =user_sleepMapper.selectByTwoDate(id,start,end);
        return userinfoBydate;

    }


}
