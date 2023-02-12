package com.huwenkang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huwenkang.reggie.entity.Orders;

public interface OrdersService extends IService<Orders> {
    void submit(Orders orders);
}
