package cn.health.service;

import cn.health.domain.User_Food;
import cn.health.domain.UserEat;
import cn.health.mapper.FoodInfMapper;
import cn.health.mapper.UserMapper;
import cn.health.mapper.User_FoodMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Vector;

@Service
public class User_FoodService {
    @Autowired
    private User_FoodMapper user_foodMapper;
    @Autowired
    private FoodInfMapper foodInfMapper;
    @Autowired
    private UserMapper userMapper;

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

    //分析用户今日的饮食以及推荐摄入食物
    public String analize(Integer id){
        String word="";

        User_Food user_food=user_foodMapper.selectCloestById(id);
        Vector<String> lack=new Vector<String >();
        Vector<String> eat=new Vector<String>();
        if(user_food.getTotal_vitaminA()<0.8){
            lack.add("维生素A");
            eat.add(foodInfMapper.selectMaxVA());
        }
        if(user_food.getTotal_vitaminB()<1){
            lack.add("维生素B");
            eat.add(foodInfMapper.selectMaxVB());
        }
        if(user_food.getTotal_vitaminC()<75){
            lack.add("维生素C");
            eat.add(foodInfMapper.selectMaxVC());
        }
        if(user_food.getTotal_vitaminD()<0.005){
            lack.add("维生素D");
            eat.add(foodInfMapper.selectMaxVD());
        }
        if(user_food.getTotal_vitaminE()<12){
            lack.add("维生素D");
            eat.add(foodInfMapper.selectMaxVE());
        }
        if(user_food.getTotal_fat()<100){
            lack.add("脂肪");
            eat.add(foodInfMapper.selectMaxfat());
        }
        if(user_food.getTotal_protein()<80){
            lack.add("蛋白质");
            eat.add(foodInfMapper.selectMaxprotein());
        }
        if(user_food.getTotal_carbs()<300){
            lack.add("碳水化合物");
            eat.add(foodInfMapper.selectMaxcarbs());
        }
        if(lack.size()==0){
            word=userMapper.selectnameByID(user_food.getUser_id())+"，您今日各类营养成分摄入充分，请您明天继续保持";
        }
        else{
            word=userMapper.selectnameByID(user_food.getUser_id() )+",用户您今日";
            for(int i=0;i<lack.size();i++){
                if(i==lack.size()-1){
                   word+=lack.get(i)+"摄入不足,";
                }
                else{
                    word+=lack.get(i)+",";
                }
            }
            word+="建议您可以多吃";
            for(int i=0;i<eat.size();i++){
                if(i==eat.size()-1){
                    word+=eat.get(i)+"等食物。";
                }
                else{
                    word+=lack.get(i)+",";
                }
            }

        }
        return word;


    }



}