package com.trade.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "TRADE-CLIENT")
public interface UserService {
    /**查询所有用户，返回boolean值**/
    @GetMapping("/users/{id}")
    String getUser(@PathVariable("id") String id);
}
