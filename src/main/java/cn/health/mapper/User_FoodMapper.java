package cn.health.mapper;
import cn.health.domain.User_Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface User_FoodMapper {

    void add(User_Food user_food);

    void update(@Param("user_id") Integer user_id,@Param("date") Date date,@Param("total_calorie")Integer total_calorie,@Param("total_carbs")Double total_carbs
            ,@Param("total_fat") Double total_fat,@Param("total_protein")Double total_protein,@Param("total_vitaminA")Double total_vitaminA
            ,@Param("total_vitaminB") Double total_vitaminB,@Param("total_vitaminC") Double total_vitaminC,@Param("total_vitaminD") Double total_vitaminD,
                @Param("total_vitaminE") Double total_vitaminE);

    User_Food selectByIdDate(@Param("user_id") Integer user_id, @Param("date") Date date);

    User_Food selectCloestById(Integer user_id);

    List<User_Food> selectALLByID(Integer user_id);

    List<User_Food> selectRangeByID(@Param("user_id") Integer user_id,@Param("startdate") Date startdate,@Param("enddate") Date enddate);

    void delete(User_Food user_food);

    void deleteALL(Integer user_id);
}
