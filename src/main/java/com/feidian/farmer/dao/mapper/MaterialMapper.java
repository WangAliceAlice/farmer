package com.feidian.farmer.dao.mapper;

import com.feidian.farmer.dao.entity.Material;
import com.feidian.farmer.dao.entity.PurchaseRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaterialMapper {

    List<Material> selectAllMaterials();

    List<PurchaseRecord> selectAllRecords();

    int insertOne(@Param("record") PurchaseRecord purchaseRecord);

    int deleteOne(@Param("rId") long rId);

}
