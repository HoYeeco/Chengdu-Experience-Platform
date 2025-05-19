package com.cupk.mapper;

import com.cupk.pojo.Order;
import com.cupk.pojo.Subscriber;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public List<Order> findALLOrders();//显示所有报名的志愿者信息

    public void addOrder(Order order);

    public Order findOrderById(Integer id);

    public void updateOrder(Order order);//修改志愿者信息

    public void deleteOrder(Integer id);//删除志愿者信息

    public void deleteOrders(int[] ids);

    public List<Order> searchOrders(Order order);

    public List<Order> searchOrdersByStr(String searchStr);
}
