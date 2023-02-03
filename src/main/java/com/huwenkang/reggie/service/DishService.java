package com.huwenkang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huwenkang.reggie.dto.DishDto;
import com.huwenkang.reggie.entity.Dish;

public interface DishService extends IService<Dish> {

    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);

}
