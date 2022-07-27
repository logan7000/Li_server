package org.li.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HomeController {
    @RequestMapping("hello")
    public HashMap<String, String> hello() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg", "hello world");
        return hashMap;
    }
}
