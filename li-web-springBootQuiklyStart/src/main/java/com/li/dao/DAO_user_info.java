package com.li.dao;

import com.li.domain.User_info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface DAO_user_info {
    //
    @Select("SELECT id,name FROM user_info WHERE account = #{account} AND password = #{password}")
    public User_info selectUserInfo(@Param("account") String account,@Param("password") String password);





}
