package cn.health.mapper;

import cn.health.domain.User_Height_Weight;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface User_Height_WeightMapper {
    User_Height_Weight selectByIdDate(@Param("user_id")Integer user_id, @Param("date")Date date); //根据用户id找到相应的信息
    List<User_Height_Weight> selecttotal(Integer user_id);//根据用户id返回该用户所有信息
    void add(User_Height_Weight user_height_weight);//向user_height_weight数据库增加一条信息
    void update_height_weight(@Param("user_id")Integer user_id,@Param("date")Date date,@Param("height")Integer height,@Param("weight")Integer weight);//根据时间和id找到某用户的一条信息，
    // 更新该信息中的身高和体重数据
    List<User_Height_Weight> selectByTwoDate(@Param("user_id") Integer user_id, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    void deleteall(Integer id);

}
