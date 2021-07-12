package cn.health.mapper;
import cn.health.domain.User;
import cn.health.domain.User_Food;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

public interface User_FoodMapper {

    void add(User_Food user_food);

    void update(@Param("user_id") Integer user_id,@Param("date") Date date,@Param("total_calorie")Integer total_calorie,@Param("total_vitaminA")Double total_vitaminA
                ,@Param("total_vitaminB") Double total_vitaminB,@Param("total_vitaminC") Double total_vitaminC,@Param("total_vitaminD") Double total_vitaminD,
                @Param("total_vitaminE") Double total_vitaminE,@Param("total_fat") Double total_fat,@Param("total_protein")Double total_protein,@Param("total_carbs")Double total_carbs);

    User_Food selectByIdDate(@Param("user_id")Integer user_id, @Param("date")Date date);

    User_Food selectCloestById(Integer user_id);
    //void update


}
