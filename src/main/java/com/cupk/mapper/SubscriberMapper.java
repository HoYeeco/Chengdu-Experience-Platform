package com.cupk.mapper;

import com.cupk.pojo.Shop;
import com.cupk.pojo.Subscriber;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubscriberMapper {
    public List<Subscriber> findALLSubscribers();//显示所有志愿者信息

    public Subscriber findSubscriberById(Integer id);//根据id查找志愿者信息

    public void addSubscriber(Subscriber Subscriber);//添加志愿者信息

    public void updateSubscriber(Subscriber Subscriber);//修改志愿者信息

    public void deleteSubscriber(Integer id);//删除志愿者信息

    public void deleteSubscribers(int[] ids);//批量提交志愿者

    public List<Subscriber> searchSubscribers(String keyword);

    public List<Subscriber> findSubscribersByPage(int offset, int size);
    public int getTotalSubscribers();

}
