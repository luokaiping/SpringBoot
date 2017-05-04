package com.demo.mapper;

import com.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by lWX458933 on 2017/4/28.
 */
public interface UserMapper {

    @Insert("insert into user('#{user.username}')")
    int save(User user);

    @Select("select * from user where id = #{id}")
    User get(@Param("id") String id);

    @Delete("delete from user where id = #{id}")
    int delete(@Param("id") String id);

    @Update("update user set username = #{user.username} where id = #{user.id}")
    int update(User user);

    @Select("select * from user")
    List<User> getAll();
}
