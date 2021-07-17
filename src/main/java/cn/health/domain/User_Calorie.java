package cn.health.domain;

import java.util.Date;

public class User_Calorie implements Comparable<User_Calorie>{

    private Date date;

    private Integer food_calorie;

    private Integer exercise_calorie;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getExercise_calorie() {
        return exercise_calorie;
    }

    public void setExercise_calorie(Integer exercise_calorie) {
        this.exercise_calorie = exercise_calorie;
    }

    public Integer getFood_calorie() {
        return food_calorie;
    }

    public void setFood_calorie(Integer food_calorie) {
        this.food_calorie = food_calorie;
    }
    
    public int compareTo(User_Calorie user_calorie) {
        return this.getDate().compareTo(user_calorie.getDate());
    }
}
