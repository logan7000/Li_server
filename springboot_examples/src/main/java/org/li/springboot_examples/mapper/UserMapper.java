package org.li.springboot_examples.mapper;


import org.apache.ibatis.annotations.*;
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
    @Insert("insert into t_user values (#{user.id},#{user.name})")
    int saveUser(@Param("user") User user);


    /**
     * @param id user.id
     */
    @Update("update t_user set name = 'luck' where id= #{id}")
    int updateUser(@Param("id") Integer id);

    /**
     * 删除用户
     *
     * @param id primary key
     * @return success {@code 1} fail {@code 0}
     */
    @Delete("delete from t_user where id = #{id};")
    int deleteById(@Param("id") Integer id);
}
