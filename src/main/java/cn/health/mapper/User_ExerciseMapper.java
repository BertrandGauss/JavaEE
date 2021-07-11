package cn.health.mapper;


import cn.health.domain.User_Exercise;
import java.util.Date;

public interface User_ExerciseMapper {
    void add(User_Exercise user_exercise);

    void updatetotal_calorie(Long total_calorie);

    User_Exercise selectByIdDate(Integer user_id, Date date);  //根据时间用户id查找信息

}
