package cn.health.domain;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class User_questionaire_Grade {
    private Long user_id;
    private Long questionnaire_id;

    @NotBlank(message = "评估时间不能为空")
    private Date date;
    @NotBlank(message = "评估得分不能为空")
    private int grade;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(Long questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
