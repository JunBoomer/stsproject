package com.jun.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import com.jun.demo.model.User;

public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getOne(Long id);

    //@Insert("INSERT INTO user(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    //void insert(User user);

    //@Update("UPDATE user SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    //void update(User user);

    //@Delete("DELETE FROM user WHERE id =#{id}")
    //void delete(Long id);

}
