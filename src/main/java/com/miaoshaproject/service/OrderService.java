package com.miaoshaproject.service;

import com.miaoshaproject.service.model.OrderModel;

/**
 * @author 1639489689@qq.com
 * @date 2019/1/6 0006 下午 9:07
 */
public interface OrderService {
    OrderModel createOrder(Integer userId,Integer itemId,Integer amount);
}
