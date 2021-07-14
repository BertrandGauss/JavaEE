package cn.health.controller;


import cn.health.domain.User_Height_Weight;
import cn.health.service.User_Height_Weight_Service;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/height_weight")
public class User_Height_WeightController {
    @Autowired
    private User_Height_Weight_Service user_height_weight_service;

    @Autowired
    private HttpServletRequest httpServletRequest;


    @RequestMapping(value = "/addheight_weight",method = {RequestMethod.POST})
    private JSONObject addheight_weight(@RequestBody User_Height_Weight user_height_weight){
        System.out.print("添加身高体重");
        JSONObject json = new JSONObject();

        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_height_weight.setUser_id(id);
        System.out.println(httpServletRequest.getSession().getId());
        json=user_height_weight_service.SetHeightWeight(user_height_weight);
        System.out.print(json);

        return json;
    }

    @RequestMapping(value = "/showbmi",method = {RequestMethod.GET})
    private JSONObject showBMI(){
        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        JSONObject user_bmi=user_height_weight_service.selectAllByIdt(id);

        user_bmi.put("code",0);
        user_bmi.put("msg","查看成功");

        return user_bmi;

    }

}
