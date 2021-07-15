package cn.health.mapper;

import cn.health.domain.User;
import cn.health.domain.UserEat;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserEatMapper {
    void add(UserEat userEat);

    List<UserEat> showOne(@Param("user_id") Integer user_id, @Param("date")Date date);

    void update(UserEat userEat);

    void delete(@Param("user_id") Integer user_id,@Param("date") Date date);

    Integer selectByDateIdName(@Param("user_id") Integer user_id,@Param("name")String name,@Param("date")Date date);
}
