package com.feidian.farmer.service;


import com.feidian.farmer.dao.entity.PurchaseRecord;
import com.feidian.farmer.dao.mapper.MaterialMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialService {

    @Resource
    public MaterialMapper materialMapper;


    public Map<String, List> getAll() {
        Map<String, List> map = new HashMap<>();
        map.put("materials", materialMapper.selectAllMaterials());
        map.put("purchaseRecords", materialMapper.selectAllRecords());
        return map;
    }

    public void save(PurchaseRecord purchaseRecord) {
        materialMapper.insertOne(purchaseRecord);
    }

    public void remove(long rId) {
        materialMapper.deleteOne(rId);
    }

}
