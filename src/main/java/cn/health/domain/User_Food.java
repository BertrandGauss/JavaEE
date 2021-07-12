package cn.health.domain;

import javax.validation.constraints.NotNull;

import java.util.Date;

public class User_Food {
    @NotNull(message = "日期不能不填")
    private Date date;
    @NotNull(message = "用户id不能不填")
    private Integer user_id;
    @NotNull(message = "当日卡路里不能不填")
    private Integer total_calorie;
    private Double total_vitaminA;
    private Double total_vitaminB;
    private Double total_vitaminC;
    private Double total_vitaminD;
    private Double total_vitaminE;
    private Double total_protein;
    private Double total_fat;
    private Double total_carbs;

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

    public Integer getTotal_calorie() {
        return total_calorie;
    }

    public void setTotal_calorie(Integer total_calorie) {
        this.total_calorie = total_calorie;
    }

    public Double getTotal_vitaminA() {
        return total_vitaminA;
    }

    public void setTotal_vitaminA(Double total_vitaminA) {
        this.total_vitaminA = total_vitaminA;
    }

    public Double getTotal_vitaminB() {
        return total_vitaminB;
    }

    public void setTotal_vitaminB(Double total_vitaminB) {
        this.total_vitaminB = total_vitaminB;
    }

    public Double getTotal_vitaminC() {
        return total_vitaminC;
    }

    public void setTotal_vitaminC(Double total_vitaminC) {
        this.total_vitaminC = total_vitaminC;
    }

    public Double getTotal_vitaminD() {
        return total_vitaminD;
    }

    public void setTotal_vitaminD(Double total_vitaminD) {
        this.total_vitaminD = total_vitaminD;
    }

    public Double getTotal_vitaminE() {
        return total_vitaminE;
    }

    public void setTotal_vitaminE(Double total_vitaminE) {
        this.total_vitaminE = total_vitaminE;
    }

    public Double getTotal_protein() {
        return total_protein;
    }

    public void setTotal_protein(Double total_protein) {
        this.total_protein = total_protein;
    }

    public Double getTotal_fat() {
        return total_fat;
    }

    public void setTotal_fat(Double total_fat) {
        this.total_fat = total_fat;
    }

    public Double getTotal_carbs() {
        return total_carbs;
    }

    public void setTotal_carbs(Double total_carbs) {
        this.total_carbs = total_carbs;
    }
}
