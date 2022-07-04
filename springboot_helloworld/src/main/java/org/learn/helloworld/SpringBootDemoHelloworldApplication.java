package org.learn.helloworld;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot启动类
 */
@SpringBootApplication
@RestController
public class SpringBootDemoHelloworldApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoHelloworldApplication.class, args);
    }

    /**
     * 创建一个控制器 /hello
     * 内部使用了hutool工具库
     * http://8080/demo/hello?who=jack
     * @param who 参数，非必须
     * @return Hello, ${who}
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if (StrUtil.isBlank(who)) {
            who = "World";
        }
        return StrUtil.format("Hello, {}!", who);
    }
}
