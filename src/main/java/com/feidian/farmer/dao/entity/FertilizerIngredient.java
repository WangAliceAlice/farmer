package com.feidian.farmer.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

/**
 * 肥料、原料关系表实体
 */

public class FertilizerIngredient {
    private Long fertilizerId;
    private Long ingredientId;
    private Short amount;

    public FertilizerIngredient() {
    }

    public Long getFertilizerId() {
        return fertilizerId;
    }

    public void setFertilizerId(Long fertilizerId) {
        this.fertilizerId = fertilizerId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FertilizerIngredient{" +
                "fertilizerId=" + fertilizerId +
                ", ingredientId=" + ingredientId +
                ", amount=" + amount +
                '}';
    }

}
