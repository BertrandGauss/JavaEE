package cn.health.service;

import cn.health.domain.*;
import cn.health.mapper.UserMapper;
import cn.health.util.MD5Util;
import cn.health.util.RandomSecurityCode;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
    @Value("${spring.mail.username}")
    private String whoAmI;
    //
    @Autowired
    private JavaMailSenderImpl mailSender;

    public Integer phoneisregister(String telephone){//查询手机号是否被注册
        Integer result=userMapper.selectByTelphone(telephone);//查询结果
        System.out.print("用户id"+result);
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
        System.out.println("pw"+pw);
        System.out.println("paw"+passw);
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

            for (int j = 0; j < ue.size(); j++) {
                System.out.println(d);
                System.out.println(ue.get(j).getDate());

                int f = d.compareTo(ue.get(j).getDate());

                if(f==0){
                    User_Calorie uc=new User_Calorie();
                    uc.setDate(uf.get(i).getDate());
                    uc.setFood_calorie(uf.get(i).getTotal_calorie());
                    uc.setExercise_calorie(ue.get(j).getTotal_calorie());
                    ucl.add(uc);
                    uf.remove(i);
                    ue.remove(j);
                    break;
                }


            }

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

    public JSONObject updatepasswd(Integer id,String old_pw,String new_pw){
        JSONObject json = new JSONObject();
        String origin_pw=userMapper.selectPasswdById(id);
        String pw=MD5Util.md5(old_pw);
        System.out.println(pw);
        System.out.println(origin_pw);
        if(!origin_pw.equals(pw)){
            json.put("code",1);System.out.println("旧密码错误");
            json.put("msg","旧密码输入错误");
        }
        else{
            userMapper.updatePw(id,MD5Util.md5(new_pw));
            json.put("code",0);
            json.put("msg","成功修改密码");
        }
        return json;
    }


    public JSONObject sendyzm(String email){
        Integer id=userMapper.selectByEmail(email);
        JSONObject json=new JSONObject();
        RandomSecurityCode randomSecurityCode=new RandomSecurityCode();
        if(id==null){
            json.put("code",0);
            json.put("msg","邮箱未被注册过");
        }
        else{
            System.out.print("发送邮件----》");
            SimpleMailMessage message = new SimpleMailMessage();
            String yzm=randomSecurityCode.getSecurityCode();
            String content="尊敬的"+userMapper.selectnameByEmail(email)+"用户，您好。您正在设置忘记密码，您的验证码为:"+yzm+"。如非本人操作，请忽略此邮件。";
            message.setTo(email);
            //添加抄送人，防止邮件发送失败
            message.setCc(whoAmI);
            message.setSubject("健康管理系统忘记密码");
            message.setText(content);
            message.setFrom(whoAmI);
            mailSender.send(message);
            json.put("code",0);
            json.put("msg","验证码发送成功");
            json.put("data",yzm);
        }
        return json;

    }

    public void forgetpw(String email,String password){
        Integer id=userMapper.selectByEmail(email);
        String pw=MD5Util.md5(password);
        userMapper.updatePw(id,pw);
    }

}
