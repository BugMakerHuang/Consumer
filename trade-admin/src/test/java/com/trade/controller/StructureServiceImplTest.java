package com.trade.controller;

import com.trade.service.impl.StrutureServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class StructureServiceImplTest {



    @Test
    public void twoDimensionalArrayToSparseArray(){
        StrutureServiceImpl strutureService = new StrutureServiceImpl();
        int arr[][] = {{0 , 0 , 1 , 0 , 0},{0 , 2 , 0 , 0 , 0},{0 , 0 , 0 , 3 , 0}};
        int[][] ints = strutureService.twoDimensionalArrayToSparseArray(arr);

        for (int i = 0; i < ints.length; i++) {
                System.out.printf("%d\t%d\t%d\t\n",ints[i][0],ints[i][1],ints[i][2]);
        }
    }
}
