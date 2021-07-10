package cn.health.domain;

import javax.validation.constraints.NotNull;

import java.util.Date;

public class User_Food {
    @NotNull(message = "日期不能不填")
    private Date date;
    @NotNull(message = "用户id不能不填")
    private Long user_id;
    @NotNull(message = "当日卡路里不能不填")
    private Long total_calorie;
    private double total_vitaminA;
    private double total_vitaminB;
    private double total_vitaminC;
    private double total_vitaminD;
    private double total_vitaminE;
    private double total_protein;
    private double total_fat;
    private double total_carbs;

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

    public double getTotal_vitaminA() {
        return total_vitaminA;
    }

    public void setTotal_vitaminA(double total_vitaminA) {
        this.total_vitaminA = total_vitaminA;
    }

    public double getTotal_vitaminB() {
        return total_vitaminB;
    }

    public void setTotal_vitaminB(double total_vitaminB) {
        this.total_vitaminB = total_vitaminB;
    }

    public double getTotal_vitaminC() {
        return total_vitaminC;
    }

    public void setTotal_vitaminC(double total_vitaminC) {
        this.total_vitaminC = total_vitaminC;
    }

    public double getTotal_vitaminD() {
        return total_vitaminD;
    }

    public void setTotal_vitaminD(double total_vitaminD) {
        this.total_vitaminD = total_vitaminD;
    }

    public double getTotal_vitaminE() {
        return total_vitaminE;
    }

    public void setTotal_vitaminE(double total_vitaminE) {
        this.total_vitaminE = total_vitaminE;
    }

    public double getTotal_protein() {
        return total_protein;
    }

    public void setTotal_protein(double total_protein) {
        this.total_protein = total_protein;
    }

    public double getTotal_fat() {
        return total_fat;
    }

    public void setTotal_fat(double total_fat) {
        this.total_fat = total_fat;
    }

    public double getTotal_carbs() {
        return total_carbs;
    }

    public void setTotal_carbs(double total_carbs) {
        this.total_carbs = total_carbs;
    }
}
