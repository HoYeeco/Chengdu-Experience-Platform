package com.cupk.controller;

import com.cupk.pojo.Order;
import com.cupk.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orderList") // 显示所有文创周边购买订单信息
    public ModelAndView findALLOrders() {
        List<Order> orders = orderService.findALLOrders();
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", orders);
        mv.setViewName("orderList");
        return mv;
    }

    @GetMapping("/ordersPage")
    public ModelAndView ordersPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                   @RequestParam(value = "size", defaultValue = "5") int size) {
        PageHelper.startPage(start, size, "id asc");
        List<Order> orders = orderService.findALLOrders();
        PageInfo<Order> page = new PageInfo<>(orders);
        ModelAndView mv = new ModelAndView();
        mv.addObject("page", page);
        mv.setViewName("orderPage");
        return mv;
    }

    @GetMapping("/addOrder") // 进入添加文创周边购买订单页面
    public String addOrder() {
        return "addOrder";
    }

    @PostMapping("/addOrder") // 添加文创周边购买订单信息
    public ModelAndView addOrder(Order order) {
        orderService.addOrder(order);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/orderList");
        return mv;
    }

    @GetMapping("/order/{id}") // 根据 id 查找文创周边购买订单信息
    public ModelAndView findOrderById(@PathVariable("id") int id) {
        Order order = orderService.findOrderById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("order", order);
        mv.setViewName("orderDetail");
        return mv;
    }

    @GetMapping("/updateOrder/{id}")
    public ModelAndView toUpdateOrder(@PathVariable("id") int id) {
        Order order = orderService.findOrderById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("order", order);
        mv.setViewName("updateOrder");
        return mv;
    }

    @PostMapping("/updateOrder") /* 修改文创周边购买订单信息 */
    public ModelAndView updateOrder(Order order) {
        orderService.updateOrder(order);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/orderList");
        return mv;
    }

    @GetMapping("/deleteOrder/{id}") // 删除文创周边购买订单信息
    public ModelAndView deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/ordersPage");
        return mv;
    }

    @GetMapping("/deleteOrders")
    public ModelAndView deleteOrders(int[] id) {
        orderService.deleteOrders(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/ordersPage");
        return mv;
    }

    @GetMapping("/searchOrders")
    public ModelAndView searchOrders(Order order) {
        List<Order> orders = orderService.searchOrders(order);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", orders);
        mv.setViewName("orderList");
        return mv;
    }

    @RequestMapping("/searchOrdersByStr")
    public String searchOrdersByStr(@RequestParam(value = "searchStr") String searchStr, Model model) {
        List<Order> orders = orderService.searchOrdersByStr(searchStr);
        model.addAttribute("orders", orders);
        return "orderList";
    }
}