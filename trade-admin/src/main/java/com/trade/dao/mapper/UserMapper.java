package com.trade.dao.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**查询所有用户**/
    List<String> allUser();
}
