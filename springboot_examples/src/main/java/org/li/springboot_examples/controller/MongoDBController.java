package org.li.springboot_examples.controller;

import org.li.springboot_examples.entity.Contract;
import org.li.springboot_examples.model.JSONResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MongoDB 控制器列表
 */
@RestController
public class MongoDBController {

    /**
     * 获取mongodb列表
     *
     * @return
     */
    @GetMapping("/get-list")
    public JSONResponse<HashMap<String, ArrayList<Contract>>> getList() {
        ArrayList<Contract> arrayList = new ArrayList<>();
        Contract contract = Contract.builder().adminName("顾娟娟").amount(1000).contractType(2).index(1).name("沧州市").no("BH123").paymentType(1).status(4).updateTime("2022年07月31日14:31:03").build();
        arrayList.add(contract);
        HashMap<String, ArrayList<Contract>> map = new HashMap<>();
        map.put("list", arrayList);
        JSONResponse<HashMap<String, ArrayList<Contract>>> response = JSONResponse.<HashMap<String, ArrayList<Contract>>>builder().code(0).data(map).build();
        return response;
    }

}
