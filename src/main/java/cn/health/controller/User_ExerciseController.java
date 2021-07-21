package cn.health.controller;

import cn.health.domain.DateRange;
import cn.health.domain.SomeDate;
import cn.health.domain.UserSport;

import cn.health.domain.User_Exercise;
import cn.health.service.User_Exercise_Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/exercise")
public class User_ExerciseController {

    @Autowired
    private User_Exercise_Service user_exercise_Service;

    @Autowired
    private HttpServletRequest httpServletRequest;


    @RequestMapping(value = "/addexercise",method = {RequestMethod.POST})
    private JSONObject addTodayexercise(@RequestBody UserSport userSport){
        System.out.print("添加运动");
        JSONObject json = new JSONObject();
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        userSport.setUser_id(id);
        json= user_exercise_Service.setTodayExercise(userSport);
        System.out.print(json);
        return json;
    }

    @RequestMapping(value = "/showexercise",method = {RequestMethod.GET})
    private JSONObject showExercise(){
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        JSONObject user_exercise=user_exercise_Service.selectAllById(id);


        return user_exercise;

    }
    
    @RequestMapping(value = "/deleteall",method = {RequestMethod.POST})
    private JSONObject deleteAllInfo(){
        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        JSONObject json = new JSONObject();
        json = user_exercise_Service.deleteall(id);
        json.put("code",0);
        json.put("msg","删除所有成功");

        return json;

    }
    @RequestMapping(value = "/deleteSomeE",method = {RequestMethod.POST})
    private JSONObject deleteSomeE(@RequestBody SomeDate someDate){
        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        JSONObject json = new JSONObject();
        user_exercise_Service.deleteSomeE(id,someDate.getDates());
        json.put("code",0);
        json.put("msg","删除部分成功");
        return json;
    }

    @RequestMapping(value = "/selectbydate",method = {RequestMethod.GET})
    private JSONObject selectByDate(@RequestBody DateRange dateRange){

        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");

        List<User_Exercise> user_date_info = user_exercise_Service.selectByDate(id,dateRange.getStartdate(),dateRange.getEnddate());


        JSONObject json = new JSONObject();

        json.put("code",0);
        json.put("data",user_date_info);
        json.put("msg","查看部分信息成功");
        json.put("count",user_date_info.size());

        return json;

    }


    @RequestMapping(value = "/deleteone",method = {RequestMethod.POST})
    private JSONObject deleteOneInfo(@RequestBody User_Exercise user_exercise){
        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        JSONObject json = new JSONObject();
        json = user_exercise_Service.deleteOne(id,user_exercise.getDate());

        json.put("code",0);
        json.put("msg","删除一条信息成功");

        return json;

    }


}
