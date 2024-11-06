package com.colak.springtutorial.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO {
    private String orderId;
    private String customerName;
}
