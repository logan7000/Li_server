package org.li.springboot_examples.mapper;


import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.li.SpringBootExamplesAppTest;
import org.li.springboot_examples.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class UserMapperTest extends SpringBootExamplesAppTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试查询全部
     */
    @Test
    public void selectAllUser() {
        List<User> userList = userMapper.selectAllUser();
        Assert.assertTrue(CollUtil.isNotEmpty(userList));
        log.info("【userList】= {}", userList);
    }

    @Test
    public void saveUser() {
        User user = User.builder().name("jack").build();
        User user1 = new User(1, "lucy");
        int affectCount = userMapper.saveUser(user1);
        log.info("插入的user数据",affectCount);
        Assert.assertEquals(1, affectCount);
    }
}
