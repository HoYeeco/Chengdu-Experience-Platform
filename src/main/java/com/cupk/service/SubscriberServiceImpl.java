package com.cupk.service;

import com.cupk.mapper.SubscriberMapper;
import com.cupk.pojo.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SubscriberServiceImpl implements SubscriberService {
    @Autowired
    private SubscriberMapper SubscriberMapper;

    @Override
    public void addSubscriber(Subscriber Subscriber) {//添加预订信息
        SubscriberMapper.addSubscriber(Subscriber);
    }

    @Override
    public void updateSubscriber(Subscriber Subscriber) {//修改预订信息
        SubscriberMapper.updateSubscriber(Subscriber);
    }

    @Override
    public void deleteSubscriber(Integer id) {//删除预订信息
       SubscriberMapper.deleteSubscriber(id);
    }

    @Override
    public List<Subscriber> findALLSubscribers() {//显示所有预订信息

        return SubscriberMapper.findALLSubscribers();
    }

    @Override
    public Subscriber findSubscriberById(Integer id) {//根据id查找预订信息
        return SubscriberMapper.findSubscriberById(id);
    }

    @Override
    public void insertSubscribers(int[] ids) {//批量提交预订信息
        SubscriberMapper.insertSubscribers(ids);
    }

}
