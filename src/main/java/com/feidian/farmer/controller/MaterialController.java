package com.feidian.farmer.controller;

import com.alibaba.fastjson.JSON;
import com.feidian.farmer.dao.entity.PurchaseRecord;
import com.feidian.farmer.service.MaterialService;
import com.feidian.farmer.share.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @RequestMapping(value = "/getAllMaterialsAndRecords", method = RequestMethod.GET)
    public ResponseBean getAllMaterials() {
        return ResponseBean.ok("success", materialService.getAll());
    }

    @RequestMapping(value = "/createPurchaseRecord", method = RequestMethod.POST)
    public ResponseBean createPurchaseRecord(@RequestBody String data) {
        PurchaseRecord purchaseRecord = JSON.parseObject(data, PurchaseRecord.class);
        materialService.save(purchaseRecord);
        return ResponseBean.ok("添加成功");
    }

    @RequestMapping(value = "/removeRecord", method = RequestMethod.POST)
    public ResponseBean removeRecord(@RequestBody String data) {
        long rId = Long.valueOf(data);
        materialService.remove(rId);
        return ResponseBean.ok("删除成功");
    }

}
