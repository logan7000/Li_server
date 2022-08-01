package org.li.springboot_examples.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import org.li.springboot_examples.dto.APIResultTO;
import org.li.springboot_examples.entity.Article;
import org.li.springboot_examples.entity.Contract;
import org.li.springboot_examples.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 获取mongodb列表
     *
     * @return
     */
    @GetMapping("/get-list")
    public APIResultTO<HashMap<String, ArrayList<Contract>>> getList() {
        ArrayList<Contract> arrayList = new ArrayList<>();
        Contract contract = Contract.builder().adminName("顾娟娟").amount(1000).contractType(2).index(1).name("沧州市").no("BH123").paymentType(1).status(4).updateTime("2022年07月31日14:31:03").build();
        arrayList.add(contract);
        HashMap<String, ArrayList<Contract>> map = new HashMap<>();
        map.put("list", arrayList);

        APIResultTO<HashMap<String, ArrayList<Contract>>> resultTO = APIResultTO.buildSuccess(map);
        return resultTO;
    }

    @PostMapping("add")
    public APIResultTO<Contract> add(ArrayList<Contract> contracts) {
        Article article = new Article(2L, RandomUtil.randomString(20), RandomUtil.randomString(150), DateUtil.date(), DateUtil.date(), 0L, 0L);
        articleRepository.save(article);
        return null;
    }

}
