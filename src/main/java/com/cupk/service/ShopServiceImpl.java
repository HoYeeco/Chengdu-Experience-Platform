package com.cupk.service;

import com.cupk.mapper.ShopMapper;
import com.cupk.pojo.Shop;
import com.cupk.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper ShopMapper;

    @Override
    public void addShop(Shop Shop) {
        ShopMapper.addShop(Shop);
    }

    @Override
    public void updateShop(Shop Shop) {//修改店铺信息
        ShopMapper.updateShop(Shop);
    }

    @Override
    public void deleteShop(Integer id) {//删除店铺信息
        ShopMapper.deleteShop(id);
    }

    @Override
    public List<Shop> findALLShops() {//显示所有店铺信息

        return ShopMapper.findALLShops();
    }

    @Override
    public Shop findShopById(Integer id) {//根据id查找店铺信息
        return ShopMapper.findShopById(id);
    }

    @Override
    public List<Shop> searchShops(String keyword) {
        return ShopMapper.searchShops(keyword);
    }
}
