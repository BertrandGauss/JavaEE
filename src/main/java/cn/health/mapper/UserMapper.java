package cn.health.mapper;

import cn.health.domain.User;

import java.util.Date;

public interface UserMapper {


    void add(User user);

    Integer selectByTelphone(String telephone);

    String selectpwByTelphone(String telephone);

    String selectnameByID(Integer id);

    Date selectbirthByID(Integer id);


}
