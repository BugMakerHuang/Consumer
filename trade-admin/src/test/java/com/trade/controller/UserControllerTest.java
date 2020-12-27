package com.trade.controller;


import com.trade.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @Test
    public void test(){
        userController.getRole("223445");
    }
}
