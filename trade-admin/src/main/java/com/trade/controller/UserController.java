package com.trade.controller;

import com.trade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author hp
 */
@RestController
public class UserController {
     @Resource
     private UserService userService;

     @GetMapping("/user/{id}")
     public  String getRole(@PathVariable("id") String id){
         System.out.println("接收到请求{/user/}"+id+"]");

         return userService.getUser(id);
     }
}
