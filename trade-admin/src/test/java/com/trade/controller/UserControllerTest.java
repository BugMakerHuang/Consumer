package com.trade.controller;


import com.trade.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = Application.class)
public class UserControllerTest {
    @MockBean
    private UserController userController;

    private MockMvc mockMvc;


    @Test
    public void getRole() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/user/223445"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        System.out.println(resultActions);

    }

    @Test
    public void hello(){
        System.out.println("hello world!");
    }
}
