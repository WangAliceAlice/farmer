package com.feidian.farmer.controller;

import com.alibaba.fastjson.JSON;
import com.feidian.farmer.dao.entity.PurchaseRecord;
import com.feidian.farmer.service.FertilizerService;
import com.feidian.farmer.share.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FertilizerController {

    private final FertilizerService fertilizerService;


    @Autowired
    public FertilizerController(FertilizerService fertilizerService) {
        this.fertilizerService = fertilizerService;
    }

    @RequestMapping(value = "/createFI", method = RequestMethod.POST)
    public ResponseBean createFI(@RequestBody String data) {
        fertilizerService.saveFI(data);
        return ResponseBean.ok("添加成功");
    }

    @RequestMapping(value = "/getAllFertilizersAndIngredients", method = RequestMethod.GET)
    public ResponseBean getAllFertilizersAndIngredients() {
        return ResponseBean.ok("success", fertilizerService.getAllFertilizersAndIngredients());
    }

    @RequestMapping(value = "/getIngredientsByFertilizer", method = RequestMethod.POST)
    public ResponseBean getIngredientsByFertilizer(@RequestBody String data) {
        long fId = Long.valueOf(data);
        return ResponseBean.ok("success", fertilizerService.getIngredientsByFertilizer(fId));
    }

    @RequestMapping(value = "/removeFI", method = RequestMethod.POST)
    public ResponseBean removeFI(@RequestBody String data) {
        long fId = Long.valueOf(data);
        fertilizerService.remove(fId);
        return ResponseBean.ok("删除成功");
    }

}
