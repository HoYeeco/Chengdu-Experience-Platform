package com.cupk.controller;

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

    @GetMapping("/subscriberList")//显示所有预订信息
    public ModelAndView findALLSubscribers(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size,
                                           @RequestParam(value = "search", defaultValue = "") String search) {
        List<Subscriber> Subscribers = subscriberService.findALLSubscribers();
        ModelAndView mv = new ModelAndView();
        mv.addObject("Subscribers", Subscribers);
        mv.addObject("pagination", new Pagination(page, size, Subscribers.size()));
        mv.addObject("searchQuery", search);
        mv.setViewName("subscriberList");
        return mv;
    }

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
    public ModelAndView addSubscriber(Subscriber subscriber) {
        subscriberService.addSubscriber(subscriber);
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

    @GetMapping("/insertSubscribers")//批量提交预订
    public String insertSubscribers() {
        return "insertSubscribers";
    }

    @PostMapping("/insertSubscribers")
    public ModelAndView insertSubscribers(@RequestParam("ids")  String ids) {
        String[] stringArray = ids.split(",");
        int[] id = new int[stringArray.length];

        // 将字符串数组中的每个元素转换为整数
        for (int i = 0; i < stringArray.length; i++) {
            id[i] = Integer.parseInt(stringArray[i].trim());
        }
        subscriberService.insertSubscribers(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/subscriberList");
        return mv;
    }

    // 新增 Pagination 类
    class Pagination {
        private int currentPage;
        private int pageSize;
        private int totalPages;

        public Pagination(int currentPage, int pageSize, int totalItems) {
            this.currentPage = currentPage;
            this.pageSize = pageSize;
            this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
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