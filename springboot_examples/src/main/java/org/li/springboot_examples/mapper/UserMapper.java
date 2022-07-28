package org.li.springboot_examples.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.li.springboot_examples.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Select("SELECT * FROM t_user")
    List<User> selectAllUser();
}
