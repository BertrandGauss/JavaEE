package cn.health.service;

import cn.health.domain.User_Food;
import cn.health.domain.UserEat;
import cn.health.mapper.FoodInfMapper;
import cn.health.mapper.User_FoodMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_FoodService {
    @Autowired
    private User_FoodMapper user_foodMapper;
    @Autowired
    private FoodInfMapper foodInfMapper;

    //添加或更新今天用户的饮食记录
    public JSONObject setTodayFood(UserEat userEat){

        Integer id=foodInfMapper.selectByName(userEat.getName()).getFood_id();
        if(id==null){
            JSONObject json = new JSONObject();
            json.put("msg","请输入正确的食物名字");
            json.put("code",1);
            return json;
        }

        User_Food uf=user_foodMapper.selectByIdDate(userEat.getUser_id(), userEat.getDate());
        if(uf==null){//用户今天还没有记录食物
            User_Food userF=new User_Food();
            userF.setDate(userEat.getDate());
            userF.setUser_id(userEat.getUser_id());
            Integer ca=(int)(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getCaloriePer100g())/100;
            userF.setTotal_calorie(ca);
            userF.setTotal_carbs(1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getCarbsPer100g())/100);
            userF.setTotal_fat(1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getFatPer100g())/100);
            userF.setTotal_protein(1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getProteinPer100g())/100);
            userF.setTotal_vitaminA(1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvAPer100g())/100);
            userF.setTotal_vitaminB(1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvBper100g())/100);
            userF.setTotal_vitaminC(1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvCper100g())/100);
            userF.setTotal_vitaminD(1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvDper100g())/100);
            userF.setTotal_vitaminE(1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvEper100g())/100);
            user_foodMapper.add(userF);
        }else{
            Integer ca=(int)(uf.getTotal_calorie()+1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getCaloriePer100g())/100);
            user_foodMapper.update(userEat.getUser_id(), userEat.getDate(),ca,uf.getTotal_carbs()+1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getCarbsPer100g())/100
            ,uf.getTotal_fat()+1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getCaloriePer100g())/100
            ,uf.getTotal_protein()+1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getCaloriePer100g())/100
            ,uf.getTotal_vitaminA()+1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvAPer100g())/100
            ,uf.getTotal_vitaminB()+1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvBper100g())/100
            ,uf.getTotal_vitaminC()+1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvCper100g())/100
            ,uf.getTotal_vitaminD()+1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvDper100g())/100
            ,uf.getTotal_vitaminE()+1.0*(userEat.getNumber()*foodInfMapper.selectByName(userEat.getName()).getWeightPerOne()*foodInfMapper.selectByName(userEat.getName()).getvEper100g())/100);
        }
        JSONObject json = new JSONObject();
        json.put("msg","添加食物成功");
        json.put("code",0);
        return json;
    }
    //找到用户最近一天吃的食物
    public User_Food selectCloestById(Integer id){
        User_Food user_food=user_foodMapper.selectCloestById(id);
        return user_food;

    }


}
