package com.feidian.farmer.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter
@Getter
@ToString
public class Fertilizer {
    Long id;
    Date fDate;
    String fName;
    Short fee;
    Short lossRate;
}
