package cn.health.mapper;

import cn.health.domain.User;
import cn.health.domain.User_Exercise; 
import cn.health.domain.User_Food;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;   

public interface UserMapper {


    void add(User user);

    Integer selectByTelphone(String telephone);

    Integer selectByEmail(String email);

    String selectnameByEmail(String email);

    String selectpwByTelphone(String telephone);

    String selectnameByID(Integer user_id);

    Date selectbirthByID(Integer user_id);

    String findgenderByID(Integer user_id);

    String selectEmailByID(Integer user_id);
    
    void updateinfo(User user);

    User selectallinfo(Integer user_id);
    
    List<User_Food> selectALLByID(Integer user_id);

    List<User_Exercise> selectTotal(Integer user_id);

    String selectPasswdById(Integer id);

    void updatePw(@Param("user_id") Integer user_id,@Param("user_password") String user_password);



}
