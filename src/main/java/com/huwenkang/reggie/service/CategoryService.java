package com.huwenkang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huwenkang.reggie.entity.Category;

public interface CategoryService extends IService<Category>{
    public void remove(long id);
}
