package com.trade.controller;

import com.trade.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.NONE,classes = Application.class)
public class AlgorithmsControllerTest {

    /**
     * 如果double类型的变量x和y都严格位于0和1之间则打印true,否则打印false
     */
    @Test
    public void test445(){
        double x = 0.1;
        double y = 1.5;
        Boolean isTrue = false;
        if(x > 0.0 && y > 0.0 ){
            if(x < 1.0 && y < 1.0){
                isTrue = true;
            }

        }
        System.out.println(isTrue);
    }

    @Test
    public void binaryToString(){
        String s = "";
        int N = 2345;
        for(int i = N ; i > 0 ; i /= 2){
            s = (i % 2) + s;
        }

        System.out.println(s);
    }

}
