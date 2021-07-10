package cn.health.domain;

import javax.validation.constraints.NotBlank;

public class Questionnaire {
    private Long questionnaire_id;
    private Long administrator_id;
    @NotBlank(message = "问卷名称不能为空")
    private String name;
    private Long problemNum;

    public Long getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(Long questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public Long getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(Long administrator_id) {
        this.administrator_id = administrator_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProblemNum() {
        return problemNum;
    }

    public void setProblemNum(Long problemNum) {
        this.problemNum = problemNum;
    }
}
