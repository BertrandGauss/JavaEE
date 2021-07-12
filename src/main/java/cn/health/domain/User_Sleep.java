package cn.health.domain;

import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public class User_Sleep {
    @NotNull(message = "日期不能不填")
    private Date date;
    @NotNull(message = "用户id不能不填")
    private Integer user_id;
    @NotNull(message = "入睡时长不能不填")
    private Integer sleeptime;
    @NotNull(message = "入睡时间不能不填")
    private Time starttime;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Integer getSleeptime() {

        return sleeptime;
    }

    public void setSleeptime(Integer sleeptime) {
        this.sleeptime = sleeptime;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
