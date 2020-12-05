package com.trade.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**查询所有用户，返回boolean值**/
    Boolean AllUser();
}
