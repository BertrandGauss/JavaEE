package cn.health.mapper;

import cn.health.domain.FoodInf;
import cn.health.domain.User;

public interface FoodInfMapper {
    FoodInf selectByName(String name);

    String selectMaxVA();//查找最富含维生素A的食物

    String selectMaxVB();//查找最富含维生素B的食物

    String selectMaxVC();//查找最富含维生素C的食物

    String selectMaxVD();//查找最富含维生素D的食物

    String selectMaxVE();//查找最富含维生素E的食物

    String selectMaxfat();//查找最富含脂肪的食物

    String selectMaxprotein();//查找最富含蛋白质的食物

    String selectMaxcarbs();//查找最富含碳水化合物的食物

}
