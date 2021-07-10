package cn.health.mapper;

import cn.health.domain.User;

public interface UserMapper {


    void add(User user);

    Integer selectByTelphone(String telephone);

    String selectpwByTelphone(String telephone);



}
