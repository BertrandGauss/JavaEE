package cn.health.mapper;

import cn.health.domain.User_Height_Weight;

public interface User_Height_WeightMapper {
    void add(User_Height_Weight user_height_weight);
    User_Height_Weight selectuserWHbyId(Long user_id);//查找用户最新的体重
}
