package cn.health.controller;

import cn.health.domain.UserSport;

import cn.health.service.User_Exercise_Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
        System.out.print(userSport.getUser_id()+userSport.getExercise_time());
        json= user_exercise_Service.setTodayExercise(userSport);
        System.out.print(json);
        return json;
    }

    @RequestMapping(value = "/showexercise",method = {RequestMethod.GET})
    private JSONObject showExercise(){
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");
        JSONObject user_exercise=user_exercise_Service.selectAllById(id);

        user_exercise.put("code",0);
        user_exercise.put("msg","查看成功");

        return user_exercise;

    }


}
