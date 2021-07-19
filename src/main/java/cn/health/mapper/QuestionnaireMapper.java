package cn.health.mapper;

import cn.health.domain.Questionnaire;
import org.apache.ibatis.annotations.Param;

public interface QuestionnaireMapper {
    void add(Questionnaire questionnaire);
    Integer selectByqID(Integer questionqrie_id);
    void update(@Param("problemNum") Integer problemNum,@Param("questionnaire_id") Integer questionnaire_id);
}
