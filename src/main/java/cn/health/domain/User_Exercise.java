package cn.health.domain;

import javax.validation.constraints.NotNull;

import java.util.Date;

public class User_Exercise {
    @NotNull(message = "日期不能不填")
    private Date date;
    @NotNull(message = "用户id不能不填")
    private Long user_id;
    @NotNull(message = "当日消耗卡路里不能不填")
    private Long total_calorie;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getTotal_calorie() {
        return total_calorie;
    }

    public void setTotal_calorie(Long total_calorie) {
        this.total_calorie = total_calorie;
    }

}
