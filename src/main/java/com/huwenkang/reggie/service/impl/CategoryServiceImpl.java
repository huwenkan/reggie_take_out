package com.huwenkang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huwenkang.reggie.entity.Category;
import com.huwenkang.reggie.mapper.CategoryMapper;
import com.huwenkang.reggie.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
