package cn.health.domain;

import java.util.Date;

public class UserBMITZ {
    //日期
    private Date date;
    //BMI
    private Double BMI;
    //体脂
    private Double TiZhi;

    private Integer weight;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public Double getTiZhi() {
        return TiZhi;
    }

    public void setTiZhi(Double tiZhi) {
        TiZhi = tiZhi;
    }

    public Integer getWeight() { return weight; }

    public void setWeight(Integer weight) { this.weight = weight; }
}
