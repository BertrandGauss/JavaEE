package cn.health.controller;

import cn.health.domain.Admin;
import cn.health.domain.Notice;
import cn.health.domain.User;
import cn.health.service.AdminService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/adminlogin", method = {RequestMethod.POST})
    public JSONObject adminlogin(@RequestBody Admin admin){
        JSONObject json=adminService.login(admin.getAdministrator_name(),admin.getPassword());
        return json;

    }

    @RequestMapping(value = "/showalluser", method = {RequestMethod.GET})
    public JSONObject adminshowalluser(){
        List<User> alluser = adminService.showalluser();
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","查看所有用户成功");
        json.put("data",alluser);
        return json;

    }

    @RequestMapping(value = "/writenotice", method = {RequestMethod.POST})
    public JSONObject adminwriteinotice(@RequestBody Notice notice){

        JSONObject json=new JSONObject();
        json=adminService.writeinotice(notice);
        return json;

    }

    @RequestMapping(value = "/shownotice", method = {RequestMethod.GET})
    public JSONObject shownotice(){

        List<Notice> allnotice=adminService.shownotice();
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","查看所有公告成功");
        json.put("data",allnotice);
        return json;

    }







}
