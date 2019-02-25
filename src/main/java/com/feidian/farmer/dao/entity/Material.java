package com.feidian.farmer.dao.entity;

/**
 * 种子或原料实体
 */
public class Material {
    private String materialName;
    private Integer price;

    public Material() {
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialName='" + materialName + '\'' +
                ", price=" + price +
                '}';
    }
}
