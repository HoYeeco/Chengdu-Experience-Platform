package com.cupk.controller;

import com.cupk.pojo.Shop;
import com.cupk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ShopService ShopService;

    @GetMapping("/shopList")//显示所有预订信息
    public ModelAndView findALLShops(){
        List<Shop>Shops= ShopService.findALLShops();
        ModelAndView mv=new ModelAndView();
        mv.addObject("Shops",Shops);
        mv.setViewName("shopList");
        return mv;
    }

    @GetMapping("/shop/{id}")//根据id查找店铺信息
    public ModelAndView findShopById(@PathVariable("id") int id){
        Shop Shop= ShopService.findShopById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("Shop",Shop);
        mv.setViewName("shopDetail");
        return mv;
    }

    @GetMapping("/addShop")//添加店铺信息
    public String addShop(){
        return "addShop";
    }

    @PostMapping("/addShop")//添加店铺信息
    public ModelAndView addShop(Shop Shop){
        ShopService.addShop(Shop);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("redirect:/shopList");
        return mv;
    }

    @GetMapping("/updateShop/{id}")
    public ModelAndView toUpdateShop(@PathVariable("id") int id){
        Shop Shop= ShopService.findShopById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("Shop",Shop);
        mv.setViewName("updateShop");
        return mv;
    }

    @PostMapping("/updateShop")/*修改店铺信息*/
    public ModelAndView updateShop(Shop Shop){
        ShopService.updateShop(Shop);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("redirect:/shopList");
        return mv;
    }

    @GetMapping("/deleteShop/{id}")//删除店铺信息
    public ModelAndView deleteShop(@PathVariable("id") int id){
        ShopService.deleteShop(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("redirect:/shopList");
        return mv;
    }
    // 添加处理查找请求的方法
    @GetMapping("/searchShops")
    public ModelAndView searchShops(@RequestParam("keyword") String keyword) {
        List<Shop> shops = ShopService.searchShops(keyword);
        ModelAndView mv = new ModelAndView();
        mv.addObject("Shops", shops);
        mv.setViewName("shopList");
        return mv;
    }
}
