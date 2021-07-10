package cn.health.mapper;
import cn.health.domain.User_Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface User_FoodMapper {

    void add(User_Food user_food);

    void updatetotal_calorie(Long total_calorie);

    void updatetotal_vitaminA(Double total_vitaminA);

    void updatetotal_vitaminB(Double total_vitaminB);

    void updatetotal_vitaminC(Double total_vitaminC);

    void updatetotal_vitaminD(Double total_vitaminD);

    void updatetotal_vitaminE(Double total_vitaminE);

    void updatetotal_protein(Double total_protein);

    void updatetotal_fat(Double total_fat);

    void updatetotal_carbs(Double total_carbs);

    User_Food selectByIdDate(Long user_id, Date date);
    //void update

    User_Food selectCloestById(Long user_id);
}
