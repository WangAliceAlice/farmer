package com.feidian.farmer.dao.entity.vo;


import com.feidian.farmer.dao.entity.Ingredient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class FIVO {

    String fName;
    Date fDate;
    Short fee;
    Short lossRate;

    List<Ingredient> ingredients;

}
