package com.cupk.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Shop {
    private Integer id;
    private String shopName;
    private String shopLocation;
    private Double shopCost;
    private String liker;
}
