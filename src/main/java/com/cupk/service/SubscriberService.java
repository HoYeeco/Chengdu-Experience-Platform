package com.cupk.service;

import com.cupk.pojo.Shop;
import com.cupk.pojo.Subscriber;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubscriberService {
    public void addSubscriber(Subscriber Subscriber);//添加预订信息

    public void updateSubscriber(Subscriber Subscriber);//修改预订信息

    public void deleteSubscriber(Integer id);//删除预订信息

    public List<Subscriber> findALLSubscribers();//显示所有预订信息

    public Subscriber findSubscriberById(Integer id);//根据id查找预订信息

    public void deleteSubscribers(int[] ids);//批量删除预订信息

    public List<Subscriber> searchSubscribers(String keyword);

    public List<Subscriber> findSubscribersByPage(int offset, int size);
    public int getTotalSubscribers();
}
