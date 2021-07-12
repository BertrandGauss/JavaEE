package cn.health.domain;

import javax.validation.constraints.NotBlank;
import java.lang.Integer;

public class Administrator {
    private Integer administrator_id;
    @NotBlank(message = "管理员名称不能为空")
    private String administrator_name;
    @NotBlank(message = "管理员密码不能为空")
    private String password;

    public Integer getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(Integer administrator_id) {
        this.administrator_id = administrator_id;
    }

    public String getAdministrator_name() {
        return administrator_name;
    }

    public void setAdministrator_name(String administrator_name) {
        this.administrator_name = administrator_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
