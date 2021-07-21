package cn.health.service;

import cn.health.domain.Admin;
import cn.health.domain.Notice;
import cn.health.domain.User;
import cn.health.mapper.AdminMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public JSONObject login(String name,String password){
        if(!adminMapper.getadmin().getAdministrator_name().equals(name) || !adminMapper.getadmin().getPassword().equals(password)){
//            System.out.println(name);
//            System.out.println(password);
            JSONObject json = new JSONObject();
            json.put("msg", "管理员登陆失败");
            json.put("code", 1);
            return json;
        }
        JSONObject json = new JSONObject();

        json.put("msg", "管理员登录成功");
        json.put("code", 0);
        return json;

    }

    public List<User> showalluser(){
        List<User> alluser=adminMapper.showalluser();
        return alluser;

    }

    //写公告
    public JSONObject writeinotice(Notice notice){
        adminMapper.writenotice(notice);

        JSONObject json = new JSONObject();

        json.put("msg", "更新公告成功");
        json.put("code", 0);
        return json;
    }

    //显示所有公告
    public List<Notice> shownotice(){
        List<Notice> allnotice = adminMapper.shownotice();
        return allnotice;

    }




}
