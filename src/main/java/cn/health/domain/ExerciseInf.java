package cn.health.domain;

public class ExerciseInf {
    private Integer exercise_id;
    private String name;
    private Integer caloriePerHour;

    public Integer getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCaloriePerHour() {
        return caloriePerHour;
    }

    public void setCaloriePerHour(Integer caloriePerHour) {
        this.caloriePerHour = caloriePerHour;
    }
}
