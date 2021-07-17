package cn.health.mapper;

import cn.health.domain.User_Sleep;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface User_SleepMapper {
    void add(User_Sleep user_sleep);

    List<User_Sleep> select30();

    void update(User_Sleep user_sleep);

    void deleteALL(Integer user_id);

    void deleteOne(@Param("date")Date date,@Param("user_id")Integer user_id );
    
    List<User_Sleep> selectByTwoDate(@Param("user_id") Integer user_id, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
