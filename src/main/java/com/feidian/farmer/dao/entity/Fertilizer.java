package com.feidian.farmer.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

/**
 * 肥料后农药实体
 */

@Setter
@Getter
public class Fertilizer {
    private Long id;
    private Date fDate;
    private String fName;
    private Short fee;
    private Short lossRate;

    public Fertilizer() {
    }

    @Override
    public String toString() {
        return "Fertilizer{" +
                "id=" + id +
                ", fDate=" + fDate +
                ", fName='" + fName + '\'' +
                ", fee=" + fee +
                ", lossRate=" + lossRate +
                '}';
    }
}
