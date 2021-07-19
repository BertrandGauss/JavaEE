package cn.health.mapper;

import cn.health.domain.User_questionaire_Grade;
import org.apache.ibatis.annotations.Param;

public interface User_questionaire_GradeMapper {

    void add(User_questionaire_Grade user_questionaire_grade);

    void getGrade(@Param("questionnarie_id") Integer questionnarie_id,@Param("user_id") Integer user_id);
}
