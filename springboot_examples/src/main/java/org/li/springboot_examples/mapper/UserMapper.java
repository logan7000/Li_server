package org.li.springboot_examples.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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


    /**
     * 保存用户
     *
     * @param user
     * @return 成功 - {@code 1} 失败 - {@code 0}
     */
    int saveUser(@Param("user") User user);

    /**
     * 删除用户
     *
     * @param id primary key
     * @return success {@code 1} fail {@code 0}
     */
    int deleteById(@Param("id") Long id);
}
