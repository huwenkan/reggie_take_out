package com.huwenkang.reggie.dto;

import com.huwenkang.reggie.entity.Setmeal;
import com.huwenkang.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
