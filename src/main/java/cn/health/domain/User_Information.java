package cn.health.domain;
import java.util.Date;

public class User_Information {

    private Integer id;
    private Date date;
    private Integer height;
    private Integer weight;
    private String gender;

    public User_Information(Integer id,Date date,Integer height,Integer weight,String gender){
        this.id=id;
        this.date=date;
        this.height=height;
        this.weight=weight;
        this.gender=gender;

    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
