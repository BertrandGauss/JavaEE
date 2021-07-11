package cn.health.domain;

import java.util.Date;

public class UserSport {
    private Long user_id;
    private String exercise_name;
    private Date exercise_date;
    private Double exercise_time;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public Date getExercise_date() {
        return exercise_date;
    }

    public void setExercise_name(Date exercise_date) {
        this.exercise_date = exercise_date;
    }

    public Double getExercise_time() {
        return exercise_time;
    }

    public void setExercise_time(Double exercise_time) {
        this.exercise_time = exercise_time;
    }

}
