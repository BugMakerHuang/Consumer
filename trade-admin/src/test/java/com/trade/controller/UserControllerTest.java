package com.trade.controller;

import com.trade.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.NONE,classes = AlgorithmsController.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Test
    public void test(){
        System.out.println("223");
    }
}
