package org.li.springboot_examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class HomeController {
    @RequestMapping("")
    public String index(){
        return "index";
    }
    @RequestMapping("hello")
    @ResponseBody
    public HashMap<String, String> hello() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg", "hello world");
        return hashMap;
    }
}
