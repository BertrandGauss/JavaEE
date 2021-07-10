package cn.health.controller;

import cn.health.domain.User;
import cn.health.domain.UserEat;
import cn.health.server.UserServer;
import cn.health.server.User_FoodServer;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class User_FoodController {
    @Autowired
    private User_FoodServer user_foodServer;


    @RequestMapping(value = "/addfood",method = {RequestMethod.POST})
    private JSONObject addTodayfood(@RequestBody UserEat userEat){
        System.out.print("添加食物");
        JSONObject json = new JSONObject();
        json=user_foodServer.setTodayFood(userEat);
        System.out.print(json);
        return json;
    }
//    @RequestMapping(value = "/showfood",method = {RequestMethod.GET})
//    private JSONObject showFood(){
//        return user_foodServer.selectCloestById();
//
//    }
}
