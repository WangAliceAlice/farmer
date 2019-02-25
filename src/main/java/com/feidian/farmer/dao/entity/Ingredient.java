package com.feidian.farmer.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 肥料或农药的原料的实体
 */

public class Ingredient {

    private Long id;
    private String ingredientName;
    private Short amount;

    public Ingredient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }
}
