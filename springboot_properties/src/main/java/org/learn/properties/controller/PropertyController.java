package org.learn.properties.controller;

import cn.hutool.core.lang.Dict;
import org.learn.properties.property.ApplicationProperty;
import org.learn.properties.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PropertyController {
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    /**
     * autowired 自动注入对象，就通过构造函数来实现了数据的读取
     *
     * @param applicationProperty
     * @param developerProperty
     */
    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
    public Dict index() {
        Dict dict = Dict.create();
        dict.set("applicationProperty", applicationProperty).set("developerProperty", developerProperty);
        return dict;
    }
}
