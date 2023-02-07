package com.huwenkang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huwenkang.reggie.entity.User;
import com.huwenkang.reggie.mapper.UserMapper;
import com.huwenkang.reggie.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
