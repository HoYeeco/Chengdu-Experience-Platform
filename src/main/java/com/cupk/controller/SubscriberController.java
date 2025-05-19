package com.cupk.controller;

import com.cupk.pojo.Shop;
import com.cupk.pojo.Subscriber;
import com.cupk.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;


    @GetMapping("/Subscriber/{id}")//根据id查找预订信息
    public ModelAndView findSubscriberById(@PathVariable("id") int id) {
        Subscriber Subscriber = subscriberService.findSubscriberById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("Subscriber", Subscriber);
        mv.setViewName("Subscriberdetail");
        return mv;
    }

    @GetMapping("/addSubscriber")//添加预订信息
    public String addSubscriber() {
        return "addSubscriber";
    }

    @PostMapping("/addSubscriber")
    public ModelAndView addSubscriber(Subscriber Subscriber) {
        subscriberService.addSubscriber(Subscriber);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/subscriberList");// 重定向到预订列表页面
        return mv;
    }

    @GetMapping("/updateSubscriber/{id}")
    public ModelAndView toUpdateSubscriber(@PathVariable("id") int id) {
        Subscriber Subscriber = subscriberService.findSubscriberById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("Subscriber", Subscriber);
        mv.setViewName("updateSubscriber");
        return mv;
    }

    @PostMapping("/updateSubscriber")/*修改预订信息*/
    public ModelAndView updateSubscriber(Subscriber Subscriber) {
        subscriberService.updateSubscriber(Subscriber);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/subscriberList");
        return mv;
    }

    @GetMapping("/deleteSubscriber/{id}")//删除预订信息
    public ModelAndView deleteSubscriber(@PathVariable("id") int id) {
        subscriberService.deleteSubscriber(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/subscriberList");
        return mv;
    }

    @GetMapping("/deleteSubscribers")//批量删除预订
    public String deleteSubscribers() {
        return "deleteSubscribers";
    }

    @PostMapping("/deleteSubscribers")
    public ModelAndView deleteSubscribers(@RequestParam("ids")  String ids) {
        String[] stringArray = ids.split(",");
        int[] id = new int[stringArray.length];

        // 将字符串数组中的每个元素转换为整数
        for (int i = 0; i < stringArray.length; i++) {
            id[i] = Integer.parseInt(stringArray[i].trim());
        }
        subscriberService.deleteSubscribers(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/subscriberList");
        return mv;
    }
    // 添加处理查找请求的方法
    @GetMapping("/searchSubscribers")
    public ModelAndView searchShops(@RequestParam("keyword") String keyword) {
        List<Subscriber> subscribers = subscriberService.searchSubscribers(keyword);
        ModelAndView mv = new ModelAndView();
        mv.addObject("Subscribers", subscribers);
        mv.setViewName("subscriberList");
        return mv;
    }

    @GetMapping("/subscriberList")//显示所有预订信息
    public ModelAndView findALLSubscribers(@RequestParam(value = "page", defaultValue = "1") int page,
                                           @RequestParam(value = "size", defaultValue = "5") int size,
                                           @RequestParam(value = "search", defaultValue = "") String search) {

        // 计算偏移量
        int offset = (page - 1) * size;
        List<Subscriber> Subscribers = subscriberService.findSubscribersByPage(offset, size);
        int totalItems = subscriberService.getTotalSubscribers();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        ModelAndView mv = new ModelAndView();
        mv.addObject("Subscribers", Subscribers);
        mv.addObject("pagination", new Pagination(page, size, totalPages));
        mv.addObject("searchQuery", search);
        mv.setViewName("subscriberList");
        return mv;
    }

    // 新增 Pagination 类
    class Pagination {
        private int currentPage;
        private int pageSize;
        private int totalPages;

        public Pagination(int currentPage, int pageSize, int totalPages) {
            this.currentPage = currentPage;
            this.pageSize = pageSize;
            this.totalPages = totalPages;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public int getTotalPages() {
            return totalPages;
        }
    }
}