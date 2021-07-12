package cn.health.domain;

import javax.validation.constraints.NotNull;

import java.util.Date;

public class User_Height_Weight {
    @NotNull(message = "日期不能不填")
    private Date date;
    @NotNull(message = "用户id不能不填")
    private Integer user_id;
    private Integer height;
    private Integer weight;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
