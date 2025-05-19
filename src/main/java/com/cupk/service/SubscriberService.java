package com.cupk.service;

import com.cupk.pojo.Subscriber;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubscriberService {
    public void addSubscriber(Subscriber subscriber);//添加预订信息

    public void updateSubscriber(Subscriber subscriber);//修改预订信息

    public void deleteSubscriber(Integer id);//删除预订信息

    public List<Subscriber> findALLSubscribers();//显示所有预订信息

    public Subscriber findSubscriberById(Integer id);//根据id查找预订信息

    public void insertSubscribers(int[] ids);//批量提交预订信息
}
