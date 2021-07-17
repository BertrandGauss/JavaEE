package cn.health.mapper;

import cn.health.domain.User_Sleep;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface User_SleepMapper {
    void add(User_Sleep user_sleep);

    List<User_Sleep> select30();

    void update(@Param("date")Date date,@Param("starttime")Time starttime,@Param("sleeptime")Integer sleeptime);

    void deleteALL(Integer user_id);

    void deleteOne(@Param("date")Date date,@Param("user_id")Integer user_id );
}
