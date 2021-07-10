package cn.health.server;

import cn.health.mapper.UserMapper;
import cn.health.domain.User;
import cn.health.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class UserServer {
    @Autowired
    private UserMapper userMapper;

    public Integer isregister(String telephone){//查询手机号是否被注册
        System.out.print(telephone);
        Integer result=userMapper.selectByTelphone(telephone);//查询结果
        System.out.print(result);
        return result;
    }
    public JSONObject register(User user){
        String telephone=user.getTelephone();
        System.out.print("123456");
        Integer re=isregister(telephone);

        //开始校验

        if(re!=null){
            JSONObject json = new JSONObject();
            json.put("msg","该手机号被注册过");
            json.put("code",5);
            return json;
        }
        user.setUser_password(MD5Util.md5(user.getUser_password()));//给用户密码加密
        userMapper.add(user);//注册验证成功，将用户插入到数据库中
        JSONObject json = new JSONObject();

        json.put("msg","注册成功");
        json.put("code",0);
        return json;

    }
    public JSONObject login(User user){
        String telephone=user.getTelephone();

        Integer re=isregister(telephone);
        String pw=MD5Util.md5(user.getUser_password());
        String passw=userMapper.selectpwByTelphone(telephone);
        if(re==null){
            JSONObject json = new JSONObject();
            json.put("msg","该用户不存在");
            json.put("code",1);
            return json;
        }
        else if(!pw.equals(passw)){
            JSONObject json = new JSONObject();
            json.put("msg","密码错误");
            json.put("code",2);
            return json;
        }
        JSONObject json = new JSONObject();

        json.put("msg","登录成功");
        json.put("code",0);
        return json;

    }
}
