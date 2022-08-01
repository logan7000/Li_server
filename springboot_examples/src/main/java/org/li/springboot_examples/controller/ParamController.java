package org.li.springboot_examples.controller;

import org.li.springboot_examples.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/param")
public class ParamController {
    /**
     * URL占位符参数
     *
     * @return
     */
    @GetMapping("/path/{name}")
    public String path(@PathVariable(value = "name") String userName) {
        return String.format("接收到name参数： %s", userName);
    }

    /**
     * query
     * url query 参数
     *
     * @return
     */
    @GetMapping("/query")
    public String pathParam(@RequestParam(value = "name") String userName) {
        return String.format("接收到name参数： %s", userName);
    }

    /**
     * 返回user对象
     *
     * @param user
     * @return
     */
    @PostMapping("/body")
    public User bodyParam(@RequestBody() User user) {
        return user;
    }

    /**
     * 去参数
     * @param userName
     * @return
     */
    @PostMapping("/post")
    public String post(@RequestParam(name = "name") String userName) {
        return userName;
    }

    /**
     * 可以不用一个个去取参数
     * @param user
     * @return
     */
    @PostMapping("/postObject")
    public User post(User user) {
        return user;
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/form-data")
    public User formData(User user) {
        return user;
    }
}
