package com.cupk.service;

import com.cupk.mapper.OrderMapper;
import com.cupk.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findALLOrders() {
        return orderMapper.findALLOrders();
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public Order findOrderById(Integer id) {
        return orderMapper.findOrderById(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderMapper.deleteOrder(id);
    }

    @Override
    public void deleteOrders(int[] ids) {
        orderMapper.deleteOrders(ids);
    }

    @Override
    public List<Order> searchOrders(Order order) {
        return orderMapper.searchOrders(order);
    }

    @Override
    public List<Order> searchOrdersByStr(String searchStr) {
        return orderMapper.searchOrdersByStr(searchStr);
    }

}
