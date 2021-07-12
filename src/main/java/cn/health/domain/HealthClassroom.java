package cn.health.domain;

import javax.validation.constraints.NotBlank;

public class HealthClassroom {
    private Integer class_id;
    private Integer administrator_id;
    @NotBlank(message = "课程名称不能为空")
    private String title;
    @NotBlank(message = "课程链接不能为空")
    private String link;
    @NotBlank(message = "课程标签不能为空")
    private String tags;
    private Integer viewers;

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(Integer administrator_id) {
        this.administrator_id = administrator_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getViewers() {
        return viewers;
    }

    public void setViewers(Integer viewers) {
        this.viewers = viewers;
    }
}
