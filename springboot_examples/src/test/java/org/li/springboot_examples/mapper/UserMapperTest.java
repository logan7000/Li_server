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
        User user = User.builder().name("jack").id(10).build();
        int affectCount = userMapper.saveUser(user);
        log.info("插入的user数据", affectCount);
        Assert.assertEquals(1, affectCount);
    }

    @Test
    public void updateUser() {
        User user = User.builder().id(10).build();
        int num = userMapper.updateUser(user.getId());
        log.info("更新的user数据", num);
        Assert.assertEquals(1, num);
    }

    @Test
    public void deleteUser() {
        User user = User.builder().id(10).build();
        int num = userMapper.deleteById(user.getId());
        log.info("删除的user数据", num);
        Assert.assertEquals(1, num);
    }
}
