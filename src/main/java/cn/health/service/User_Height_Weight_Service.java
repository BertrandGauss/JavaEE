package cn.health.service;

import cn.health.domain.UserBMITZ;
import cn.health.mapper.UserMapper;
import com.alibaba.fastjson.JSONObject;
import cn.health.domain.User_Height_Weight;
import cn.health.mapper.User_Height_WeightMapper;
import cn.health.util.GetAgeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.health.domain.User_Information;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class User_Height_Weight_Service {
    @Autowired
    private User_Height_WeightMapper user_height_weightMapper;
    @Autowired
    private UserMapper userMapper;

    public JSONObject SetHeightWeight(User_Height_Weight user_height_weight){
        User_Height_Weight uhw = user_height_weightMapper.selectByIdDate(user_height_weight.getUser_id(),user_height_weight.getDate());
        if(uhw==null){
            User_Height_Weight uHW = new User_Height_Weight();
            uHW.setUser_id(user_height_weight.getUser_id());
            uHW.setDate(user_height_weight.getDate());
            uHW.setHeight(user_height_weight.getHeight());
            uHW.setWeight(user_height_weight.getWeight());
            user_height_weightMapper.add(uHW);
        }
        else{
            user_height_weightMapper.update_height_weight(user_height_weight.getUser_id(),user_height_weight.getDate(),user_height_weight.getHeight(),user_height_weight.getWeight());
        }
        JSONObject json = new JSONObject();
        json.put("msg","添加身高体重信息成功");
        json.put("code",0);
        return json;
    }

    public JSONObject selectAllByIdt(Integer id){
        Date birth= userMapper.selectbirthByID(id);
        List<User_Height_Weight> user_H_W = user_height_weightMapper.selecttotal(id);
        List<UserBMITZ> user_BmiandTizhi = new ArrayList<UserBMITZ>();
        for(int i=0;i<user_H_W.size();i++){
            Integer height=user_H_W.get(i).getHeight();
            Integer weight=user_H_W.get(i).getWeight();
            Double bmi=(double)weight/((height/1000)^2);
            int mark=0;
            if(userMapper.findgenderByID(id).equals("male")){
                mark=1;
            }
            Double tizhi=(double)1.2*bmi+0.23*GetAgeUtil.getAge(birth)-5.4-10.8*mark;
            UserBMITZ userBMITZ =new UserBMITZ();
            userBMITZ.setDate(user_H_W.get(i).getDate());
            userBMITZ.setBMI(bmi);
            userBMITZ.setTiZhi(tizhi);
            userBMITZ.setWeight(weight);
            user_BmiandTizhi.add(userBMITZ);
        }
        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","BMI和体脂展示");
        json.put("data",user_BmiandTizhi);
        return json;

    }

    //查找指定日期内的身体记录
    public JSONObject  searchInfor(Integer user_id,Date startdate,Date enddate){
        JSONObject json=new JSONObject();
        List<User_Height_Weight> user_height_weights= user_height_weightMapper.selectByTwoDate(user_id,startdate,enddate);
        System.out.println(user_height_weights.size());
        json.put("code",0);
        json.put("msg","查询成功");
        json.put("date",user_height_weights);
        return json;

    }
    
   //返回所有身高体重信息
 public JSONObject showAllinfo(Integer id){

        List<User_Height_Weight> user_info = user_height_weightMapper.selecttotal(id);

        String gender=user_height_weightMapper.selectgender(id);

        List<User_Information> user_all_info=new ArrayList<User_Information>();
        for (int i=0;i<user_info.size();i++){
            User_Information ui=new User_Information(user_info.get(i).getDate(),user_info.get(i).getHeight(),user_info.get(i).getWeight(),gender);
            user_all_info.add(ui);

        }


        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","所有身高体重信息");
        json.put("count",user_all_info.size());
        json.put("data",user_all_info);

        return json;

    }

    //修改具体的一条体重记录
    public JSONObject updateInfor(User_Height_Weight user_height_weight){
        JSONObject json =new JSONObject();
        user_height_weightMapper.update_height_weight(user_height_weight.getUser_id(),user_height_weight.getDate(),user_height_weight.getHeight(),user_height_weight.getWeight());
        json.put("msg","修改身高体重信息成功");
        json.put("code",0);
        return json;
    }
    
    //删除所有记录
    public JSONObject deleteAll(Integer id){

        user_height_weightMapper.deleteall(id);

        JSONObject json=new JSONObject();
        json.put("code",0);
        json.put("msg","删除全部记录成功");
        return json;

    }

    //删除某条身高体重
    public  void deleteOne(Integer id,Date date){
        user_height_weightMapper.deleteone(id,date);
    }
    //查找记录
    public List<User_Height_Weight> selectByDate(Integer id,Date stat,Date end){
        List<User_Height_Weight> userinfoBydate =user_height_weightMapper.selectByTwoDate(id,stat,end);
        return userinfoBydate;

    }
}
