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
        int[][] arr = {{0 , 0 , 1 , 0 , 0},{0 , 2 , 0 , 0 , 0},{0 , 0 , 0 , 3 , 0}};
        int[][] ints = strutureService.twoDimensionalArrayToSparseArray(arr);

        for (int[] anInt : ints) {
            System.out.printf("%d\t%d\t%d\t\n", anInt[0], anInt[1], anInt[2]);
        }
    }

    @Test
    public void sparseArrayTotwoDimensionalArray(){
        StrutureServiceImpl strutureService = new StrutureServiceImpl();
        int[][] arr = {{3 , 5 , 3},{0 , 2 , 1},{1 , 1 , 2},{2, 3 , 3}};
        int[][] ints = strutureService.sparseArrayTotwoDimensionalArray(arr);

       for (int i = 0;i < ints.length;i++){
           for (int j = 0;j < ints[i].length;j++){
               System.out.printf("%d\t",ints[i][j]);
           }
           System.out.println();
       }
    }

}
