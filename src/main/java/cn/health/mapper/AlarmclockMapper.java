package cn.health.mapper;

import cn.health.domain.Alarmclock;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AlarmclockMapper {
    void add(Alarmclock alarmclock);

    List<Alarmclock> selectByDate(Date date);

    List<Alarmclock> selectALLByID(Integer user_id);
}
