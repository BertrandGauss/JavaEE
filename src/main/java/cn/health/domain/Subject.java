package cn.health.domain;

import javax.validation.constraints.NotNull;

public class Subject {
    @NotNull(message = "题目id不能不填")
    private Integer subject_id;
    @NotNull(message = "问卷id不能不填")
    private Integer questionnaire_id;
    private String Q;
    private String A1;
    private String A2;
    private String A3;
    private String A4;
    private Integer point;

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(Integer questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public String getQ() {
        return Q;
    }

    public void setQ(String q) {
        Q = q;
    }

    public String getA1() {
        return A1;
    }

    public void setA1(String a1) {
        A1 = a1;
    }

    public String getA2() {
        return A2;
    }

    public void setA2(String a2) {
        A2 = a2;
    }

    public String getA3() {
        return A3;
    }

    public void setA3(String a3) {
        A3 = a3;
    }

    public String getA4() {
        return A4;
    }

    public void setA4(String a4) {
        A4 = a4;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}