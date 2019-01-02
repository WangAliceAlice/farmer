package com.feidian.farmer.dao.mapper;

import com.feidian.farmer.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectOneByUsername(String username);

}
