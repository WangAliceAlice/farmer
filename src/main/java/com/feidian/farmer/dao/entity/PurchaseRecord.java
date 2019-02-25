package com.feidian.farmer.dao.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * 购买记录实体
 */

public class PurchaseRecord {

    @Getter
    @Setter
    private Long rId;
    private String materialName;
    private Integer amount;
    private Integer price;
    private Date purchaseDate;
    private String remarks;

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public PurchaseRecord() {
    }

    @Override
    public String toString() {
        return "PurchaseRecord{" +
                "rId=" + rId +
                ", materialName='" + materialName + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }

}
