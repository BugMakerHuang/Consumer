package com.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Value("${server.port}")
    private Integer port;



        @GetMapping("/users/{id}")
        public String getUser(@PathVariable("id") String id) throws InterruptedException {
            System.out.println("这里是提供者，请注意接收");
            return "testUser:["+"接收到请求[/users/" + id + "]" + port;
        }


}
