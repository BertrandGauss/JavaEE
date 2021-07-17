package cn.health.service;

import cn.health.mapper.UserMapper;
import cn.health.domain.User;
import cn.health.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Integer phoneisregister(String telephone){//查询手机号是否被注册
        System.out.print(telephone);
        Integer result=userMapper.selectByTelphone(telephone);//查询结果
        System.out.print(result);
        return result;
    }
    public Integer emailisregister(String email){//查询手机号是否被注册
        System.out.print(email);
        Integer result=userMapper.selectByEmail(email);//查询结果
        System.out.print(result);
        return result;
    }
    public JSONObject register(User user){ ;
        Integer re=phoneisregister(user.getTelephone());
        Integer res=emailisregister(user.getEmail());

        //开始校验

        if(re!=null){
            JSONObject json = new JSONObject();
            json.put("msg","该手机号被注册过");
            json.put("code",1);
            return json;
        }
        if(res!=null){
            JSONObject json = new JSONObject();
            json.put("msg","该邮箱被注册过");
            json.put("code",2);
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

        Integer re=phoneisregister(telephone);
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
    
    public String selectNameById(Integer id){
        String user_name = userMapper.selectnameByID(id);
        return user_name;

    }
    
      public void updateinfo(User user){
        userMapper.updateinfo(user);

    }

    public  List<User> showuserinfo(Integer id){
        List<User> user_info = userMapper.selectallinfo(id);
        return user_info;

    }
}
