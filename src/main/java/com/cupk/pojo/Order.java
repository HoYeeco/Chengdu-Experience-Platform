package com.cupk.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private String name;
    private String phone;
    private String product;
    private Integer quantity;
    private Double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private String status;
}
