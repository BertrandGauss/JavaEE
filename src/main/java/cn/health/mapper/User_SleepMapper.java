package cn.health.mapper;

import cn.health.domain.User_Sleep;

import java.util.List;

public interface User_SleepMapper {
    void add(User_Sleep user_sleep);
    List<User_Sleep> select30();
}
