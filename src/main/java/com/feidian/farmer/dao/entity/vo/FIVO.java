package com.feidian.farmer.dao.entity.vo;


import com.feidian.farmer.dao.entity.Ingredient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

/**
 * 用于组装肥料和原料，以减少网络IO次数
 */
@Getter
@Setter
public class FIVO {

    private String fName;
    private Date fDate;
    private Short fee;
    private Short lossRate;
    private List<Ingredient> ingredients;

    @Override
    public String toString() {
        return "FIVO{" +
                "fName='" + fName + '\'' +
                ", fDate=" + fDate +
                ", fee=" + fee +
                ", lossRate=" + lossRate +
                ", ingredients=" + ingredients +
                '}';
    }
}
