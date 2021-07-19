package cn.health.domain;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class User_questionnaire_Grade {
    private Integer user_id;
    private Integer questionnaire_id;

    @NotBlank(message = "评估时间不能为空")
    private Date date;
    @NotBlank(message = "评估得分不能为空")
    private Integer grade;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(Integer questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
