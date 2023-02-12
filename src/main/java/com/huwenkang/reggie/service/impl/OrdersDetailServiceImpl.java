package com.huwenkang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huwenkang.reggie.entity.OrderDetail;
import com.huwenkang.reggie.mapper.OrdersDetailMapper;
import com.huwenkang.reggie.service.OrdersDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrdersDetailServiceImpl extends ServiceImpl<OrdersDetailMapper, OrderDetail> implements OrdersDetailService {
}
