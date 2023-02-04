package com.huwenkang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huwenkang.reggie.dto.SetmealDto;
import com.huwenkang.reggie.entity.Setmeal;

public interface SetmealService extends IService<Setmeal> {

    public void saveWithDish(SetmealDto setmealDto);
}
