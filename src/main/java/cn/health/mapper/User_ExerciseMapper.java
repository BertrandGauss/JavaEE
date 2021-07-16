package cn.health.mapper;


import cn.health.domain.User_Exercise;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface User_ExerciseMapper {
    void add(User_Exercise user_exercise);

    void updatetotal_calorie(@Param("total_calorie") Integer total_calorie, @Param("date") Date date, @Param("user_id") Integer user_id);

    User_Exercise selectByIdDate(@Param("user_id") Integer user_id,@Param("date") Date date);  //根据时间用户id查找信息

    List<User_Exercise> selectTotal(Integer user_id);
    
    void deleteall(Integer user_id);

    List<User_Exercise> selectByTwoDate(@Param("user_id") Integer user_id,@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    void deleteone(@Param("user_id")Integer user_id,@Param("date")Date date);

}
