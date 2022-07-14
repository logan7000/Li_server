package org.li.config.controller;

import org.li.config.dao.ContractJpa;
import org.li.config.entity.Contract;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/docker")
public class DockerController {
    @Resource
    private ContractJpa contractJpa;

    //查找所有数据
    @GetMapping("findAll")
    public List<Contract> findAll() {
        return this.contractJpa.findAll();
    }

    //查找所有数据
    @PostMapping("")
    public Contract addOne(@RequestBody  Contract contract) {
        System.out.println(contract);
        Contract contract1 = new Contract();
        contract1.setAmount("110");
        contract1.setId("11");
        return contractJpa.saveAndFlush(contract1);
    }
}
