package com.cupk.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Subscriber {
    private Integer id;//预订id
    private String name;//预订人姓名
    private String sex;//预订人性别
    private String Id_Card_Number;//预订人身份证号码
    private String phone;//预订电话
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;//预订参观时间
    private String hdid;//预订参观地点
}
