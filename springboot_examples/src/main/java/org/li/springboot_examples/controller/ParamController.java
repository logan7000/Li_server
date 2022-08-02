package org.li.springboot_examples.controller;

import org.li.springboot_examples.dto.APIResultTO;
import org.li.springboot_examples.entity.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

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
    public APIResultTO<String> queryParam(@RequestParam(value = "name") String userName) {
        return APIResultTO.buildSuccess("your query params is " + userName);
    }

    /**
     * 返回user对象
     *
     * @param user
     * @return
     */
    @PostMapping("/body")
    public APIResultTO<User> bodyParam(@RequestBody() User user) {
        return APIResultTO.buildSuccess(user,"your body is user");
    }

    /**
     * 去参数
     *
     * @param userName
     * @return
     */
    @PostMapping("/post")
    public String post(@RequestParam(name = "name") String userName) {
        return userName;
    }

    /**
     * 可以只取一个参数
     */
    @PostMapping("/post-key")
    public APIResultTO<HashMap<String, Object>> post(@RequestParam(name = "name") String userName, @RequestParam(name = "id",required = false) int id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name",userName);
        hashMap.put("id",id);
        return APIResultTO.buildSuccess(hashMap,"your key is in data");
    }

    /**
     * @param user
     * @return
     */
    @PostMapping("/form-data")
    public User formData(User user, @RequestParam(value = "file",required = false) MultipartFile file , @RequestParam(value = "file2",required = false) MultipartFile file2, HttpServletRequest request) {
        System.out.println(user);
        System.out.println(file);
        System.out.println(file2);
        String id = request.getParameter("id");
        String title = request.getParameter("name");
        System.out.println("获取到字段:" + id);
        System.out.println("获取到字段:" + title);
        return user;
    }
}
