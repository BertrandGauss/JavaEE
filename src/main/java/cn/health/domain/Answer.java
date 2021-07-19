package cn.health.domain;

import java.util.Date;
import java.util.List;

public class Answer {
    private Integer questionaire_id;
    private Integer user_id;
    private List<Integer> answer;
    private Date date;


    public Integer getQuestionaire_id() {
        return questionaire_id;
    }

    public void setQuestionaire_id(Integer questionaire_id) {
        this.questionaire_id = questionaire_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
