package cn.health.mapper;

import cn.health.domain.Admin;
import cn.health.domain.Notice;
import cn.health.domain.User;

import java.util.List;

public interface AdminMapper {

    Admin getadmin();
    List<User> showalluser();
    void writenotice(Notice notice);
    List<Notice> shownotice();

}
