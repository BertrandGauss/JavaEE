package cn.health.domain;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Time;

public class Alarmclock {
    private Integer id;
    private Integer user_id;
    private String name;
    @NotBlank(message = "闹钟设定时间不能为空")
    private Time time;
    private String type;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
