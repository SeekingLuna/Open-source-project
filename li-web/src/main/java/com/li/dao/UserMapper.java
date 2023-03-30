package com.li.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
