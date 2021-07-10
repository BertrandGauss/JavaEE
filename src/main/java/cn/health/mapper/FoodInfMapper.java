package cn.health.mapper;

import cn.health.domain.FoodInf;
public interface FoodInfMapper {
    FoodInf selectByName(String name);
}
