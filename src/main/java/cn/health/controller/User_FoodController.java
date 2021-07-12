package cn.health.controller;

import cn.health.domain.UserEat;
import cn.health.domain.User_Food;
import cn.health.service.User_FoodService;
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
    //用户添加食物
    @RequestMapping(value = "/addfood",method = {RequestMethod.POST})
    private JSONObject addTodayfood(@RequestBody UserEat userEat){
        System.out.print("添加食物");
        JSONObject json = new JSONObject();
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        userEat.setUser_id(id);
        json= user_foodService.setTodayFood(userEat);
        System.out.print(json);
        return json;
    }
    //展示用户最近的饮食
    @RequestMapping(value = "/showfood",method = {RequestMethod.GET})
    private JSONObject showFood(){
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        User_Food user_food= user_foodService.selectCloestById(id);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","查看成功");
        json.put("data",user_food);
        return json;
    }
    //饮食分析报告
    @RequestMapping(value = "/foodAnaly",method = {RequestMethod.GET})
    private JSONObject foodAnaly(){
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        User_Food user_food= user_foodService.selectCloestById(id);
        String analy=user_foodService.analize(id);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","分析成功");
        json.put("data",analy);
        return json;
    }
}
