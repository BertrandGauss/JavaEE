package cn.health.server;

import cn.health.mapper.User_SleepMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_sleepServer {
    @Autowired
    private User_SleepMapper user_sleepMapper;

//    public JSONObject getMonthSleepTime(){
//
//
//    }


}
