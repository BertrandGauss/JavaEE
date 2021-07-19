package cn.health.mapper;

import cn.health.domain.Subject;

import java.util.List;

public interface Subject_Mapper {

    List<Subject> getALL(Integer questionnarie_id);

    List<Integer> getScore(Integer questionnarie_id);

    void add(Subject subject);
}
