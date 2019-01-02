package com.feidian.farmer.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class FertilizerIngredient {
    Long fertilizerId;
    Date fDate;
    String fName;
    Short fee;
    Short lossRate;
    Long ingredientId;
    String ingredientName;
    Short amount;
}
