package cn.health.mapper;

import cn.health.domain.User;

import java.util.Date;

public interface UserMapper {


    void add(User user);

    Integer selectByTelphone(String telephone);

    String selectpwByTelphone(String telephone);

    String selectnameByID(Integer user_id);

    Date selectbirthByID(Integer user_id);

    String findgenderByID(Integer user_id);

    String selectEmailByID(Integer user_id);

    Integer selectByEmail(String email);


}
