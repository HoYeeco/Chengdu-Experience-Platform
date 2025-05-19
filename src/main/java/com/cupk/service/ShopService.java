package com.cupk.service;

import com.cupk.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopService {
    public List<Shop> findALLShops();//显示所有店铺信息

    public Shop findShopById(Integer id);

    public void addShop(Shop Shop);

    public void updateShop(Shop Shop);

    public void deleteShop(Integer id);

    public List<Shop> searchShops(String keyword);
}
