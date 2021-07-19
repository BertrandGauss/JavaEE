package cn.health.mapper;

import cn.health.domain.User_questionnaire_Grade;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface User_questionnaire_GradeMapper {

    void add(User_questionnaire_Grade user_questionnaire_grade);

    void getGrade(@Param("questionnaire_id") Integer questionnaire_id,@Param("user_id") Integer user_id);

    void update(User_questionnaire_Grade user_questionnaire_grade);

    Integer findEist(@Param("questionnaire_id") Integer questionnaire_id, @Param("user_id") Integer user_id, @Param("date")Date date);
}
