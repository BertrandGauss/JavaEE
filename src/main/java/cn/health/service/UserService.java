package cn.health.service;

import cn.health.domain.User_Calorie;
import cn.health.domain.User_Exercise;
import cn.health.domain.User_Food;
import cn.health.mapper.UserMapper;
import cn.health.domain.User;
import cn.health.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.lang.StrictMath.max; 

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

    public User showuserinfo(Integer id){
        User user_info = (User) userMapper.selectallinfo(id);
        return user_info;

    }
    
    public List<User_Calorie> selectCaById(Integer id) {

        List<User_Food> uf = userMapper.selectALLByID(id);

        List<User_Exercise> ue = userMapper.selectTotal(id);

        List<User_Calorie> ucl = new ArrayList<>();



        for (int i=uf.size()-1;i>=0;i--) {

            Date d=uf.get(i).getDate();
            System.out.println("111"+d+"111");
            for (int j = 0; j < ue.size(); j++) {

                int f = d.compareTo(ue.get(j).getDate());
                System.out.println("222"+ue.get(j).getDate()+"222");
                System.out.println(f);
                if(f==0){
                    User_Calorie uc=new User_Calorie();
                    uc.setDate(uf.get(i).getDate());
                    uc.setFood_calorie(uf.get(i).getTotal_calorie());
                    uc.setExercise_calorie(ue.get(i).getTotal_calorie());
                    ucl.add(uc);
                    uf.remove(i);
                    ue.remove(j);
                    break;
                }


            }
            System.out.println(uf.size());
            System.out.println(ue.size());
        }



        for(int i=0;i<uf.size();i++){
            User_Calorie uc=new User_Calorie();
            uc.setDate(uf.get(i).getDate());
            uc.setFood_calorie(uf.get(i).getTotal_calorie());
            uc.setExercise_calorie(null);
            ucl.add(uc);

        }

        for(int i=0;i<ue.size();i++){
            User_Calorie uc=new User_Calorie();
            uc.setDate(ue.get(i).getDate());
            uc.setFood_calorie(null);
            uc.setExercise_calorie(ue.get(i).getTotal_calorie());
            ucl.add(uc);

        }
        
        Collections.sort(ucl);
        return ucl;
    }
}
