package cn.health.controller;

import cn.health.domain.DateRange;
import cn.health.domain.User;
import cn.health.domain.UserEat;
import cn.health.domain.User_Food;
import cn.health.service.User_FoodService;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin
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
        user_foodService.addTodayEat(userEat);
        json= user_foodService.setTodayFood(userEat);
        System.out.print(json);
        return json;
    }

    //展示用户全部饮食情况
    @RequestMapping(value = "/showallfood",method = {RequestMethod.GET})
    private JSONObject showAllInfor(){
        JSONObject json = new JSONObject();
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        List<User_Food> user_foods = user_foodService.showAllFood(id);
        json.put("code",0);
        json.put("msg","展示饮食分析成功");
        json.put("data",user_foods);
        return  json;

    }

    //删除一条饮食记录
    @RequestMapping(value = "/deletefood",method = {RequestMethod.POST})
    private JSONObject deleteInfor(@RequestBody  User_Food user_food) {
        System.out.println("删除 "+user_food.getDate());
        JSONObject json = new JSONObject();
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_food.setUser_id(id);
        user_foodService.deleteFood(user_food);
        json.put("code",0);
        json.put("msg","删除饮食记录成功");
        return  json;
    }

    //删除全部
    @RequestMapping(value = "/deleteAllFood",method = {RequestMethod.POST})
    private JSONObject deleteALLInfor() {
        JSONObject json = new JSONObject();
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_foodService.deleteALLFood(id);
        json.put("code",0);
        json.put("msg","删除用户全部饮食记录成功");
        return  json;
    }


    //展示用户某天的饮食
    @RequestMapping(value = "/showeat",method = {RequestMethod.POST})
    private JSONObject showTodayEat(@RequestBody User_Food user_food){
        JSONObject json = new JSONObject();
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        List<UserEat> userEats = user_foodService.showEat(id,user_food.getDate());
        json.put("code",0);
        json.put("msg","展示具体饮食");
        json.put("data",userEats);
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

    //展示用户一段时间的饮食
    @RequestMapping(value = "/searchFood",method = {RequestMethod.POST})
    private JSONObject searchFood(@RequestBody  DateRange dateRange){
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        List<User_Food> user_foods= user_foodService.showRangeEat(id,dateRange.getStartdate(),dateRange.getEnddate());
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","查看成功");
        json.put("data",user_foods);
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
