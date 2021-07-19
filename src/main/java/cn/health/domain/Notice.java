package cn.health.domain;

import java.util.Date;

public class Notice {
    private Integer notice_id;
    private Integer administrator_id;
    private String content;
    private Date date;

    public Date getDate() {
        return date;
    }

    public Integer getAdministrator_id() {
        return administrator_id;
    }

    public Integer getNotice_id() {
        return notice_id;
    }

    public String getContent() {
        return content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAdministrator_id(Integer administrator_id) {
        this.administrator_id = administrator_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNotice_id(Integer notice_id) {
        this.notice_id = notice_id;
    }
}
