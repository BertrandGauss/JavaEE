package cn.health.domain;

public class ExerciseInf {
    private Long exercise_id;
    private String name;
    private Long caloriePreHour;

    public Long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Long exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCaloriePreHour() {
        return caloriePreHour;
    }

    public void setCaloriePreHour(Long caloriePreHour) {
        this.caloriePreHour = caloriePreHour;
    }
}
