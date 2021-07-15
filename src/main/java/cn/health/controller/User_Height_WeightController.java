package cn.health.controller;


import cn.health.domain.DateRange;
import cn.health.domain.User_Height_Weight;
import cn.health.service.User_Height_Weight_Service;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

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
    @RequestMapping( value= "/selectheight_weight",method = {RequestMethod.POST})
    private  JSONObject searchInfor(@RequestBody DateRange dateRange){//@RequestParam(value ="startdate",required = true)String startdate,@RequestParam(value ="enddate",required = true)String enddate){
        System.out.print("查找身高体重");
        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        JSONObject json = new JSONObject();
        json=user_height_weight_service.searchInfor(id,dateRange.getStartdate(),dateRange.getEnddate());
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

    @RequestMapping(value = "/showinformation",method = {RequestMethod.GET})
    private JSONObject showINFO(){
        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        JSONObject user_info=user_height_weight_service.showAllinfo(id);

        user_info.put("code",0);
        user_info.put("msg","查看成功");

        return user_info;

    }
   @RequestMapping(value = "/updateheight_weight",method = {RequestMethod.POST})    
   private JSONObject updatehw(@RequestBody User_Height_Weight user_height_weight){
       Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
       user_height_weight.setUser_id(id);
       JSONObject json = new JSONObject();
       json = user_height_weight_service.updateInfor(user_height_weight);
       json.put("code",0);
       json.put("msg","更改信息成功");

       return json;

   
   }
    
    @RequestMapping(value = "/deleteall",method = {RequestMethod.POST})
    private JSONObject deleteAllInfo(){
        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");

        JSONObject json = new JSONObject();

        json = user_height_weight_service.deleteAll(id);

        json.put("code",0);
        json.put("msg","删除所有成功");

        return json;

    }

    @RequestMapping(value = "/deleteOne", method = {RequestMethod.POST})
    private JSONObject deleteOne(@RequestBody User_Height_Weight user_height_weight){
        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        user_height_weight.setUser_id(id);
        JSONObject json = new JSONObject();
        return json;
    }

    @RequestMapping(value = "/selectbydate",method = {RequestMethod.GET})
    private JSONObject selectByDate(@RequestBody DateRange dateRange){
        Integer id=(Integer) httpServletRequest.getSession().getAttribute("LOGIN_USER");

        List<User_Height_Weight> user_date_info = user_height_weight_service.selectByDate(id,dateRange.getStartdate(),dateRange.getEnddate());


        JSONObject json = new JSONObject();

        json.put("code",0);
        json.put("data",user_date_info);
        json.put("msg","查看部分信息成功");

        return json;

    }

}
