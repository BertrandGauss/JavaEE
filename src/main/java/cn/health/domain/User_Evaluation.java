package cn.health.domain;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class User_Evaluation {
    private Integer user_id;
    @NotBlank(message = "评估时间不能为空")
    private Date date;
    @NotBlank(message = "评估得分不能为空")
    private int grade;


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
