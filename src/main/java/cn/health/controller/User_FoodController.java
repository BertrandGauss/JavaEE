package cn.health.controller;

import cn.health.domain.UserEat;
import cn.health.domain.User_Food;
import cn.health.server.User_FoodService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/food")
public class User_FoodController {
    @Autowired
    private User_FoodService user_foodService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/addfood",method = {RequestMethod.POST})
    private JSONObject addTodayfood(@RequestBody UserEat userEat){
        System.out.print("添加食物");
        JSONObject json = new JSONObject();
        Long id=(Long)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        userEat.setUser_id(id);
        json= user_foodService.setTodayFood(userEat);
        System.out.print(json);
        return json;
    }
    @RequestMapping(value = "/showfood",method = {RequestMethod.GET})
    private JSONObject showFood(){
        Long id=(Long)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        User_Food user_food= user_foodService.selectCloestById(id);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","查看成功");
        json.put("data",user_food);
        return json;

    }
}
