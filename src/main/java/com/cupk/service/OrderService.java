package com.cupk.service;

import com.cupk.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderService {
    public List<Order> findALLOrders();//显示所有订单信息

    public void addOrder(Order order);

    public Order findOrderById(Integer id);

    public void updateOrder(Order order);//修改订单信息

    public void deleteOrder(Integer id);

    public void deleteOrders(int[] ids);

    public List<Order> searchOrders(Order order);

    public List<Order> searchOrdersByStr(String searchStr);

}
