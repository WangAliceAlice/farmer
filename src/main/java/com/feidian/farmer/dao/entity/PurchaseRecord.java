package com.feidian.farmer.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter
@Getter
@ToString
public class PurchaseRecord {
    private Long rId;
    private String materialName;
    private Integer amount;
    private Integer price;
    private Date purchaseDate;
    private String remarks;
}
