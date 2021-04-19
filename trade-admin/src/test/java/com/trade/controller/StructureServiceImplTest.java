package com.trade.controller;

import com.trade.dao.entity.ArrayQueue;
import com.trade.service.impl.StrutureServiceImpl;
import com.trade.utils.ApiUtils;
import io.swagger.annotations.Api;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Arrays;


public class StructureServiceImplTest {

    @Test
    public void twoDimensionalArrayToSparseArray() throws IOException {
        StrutureServiceImpl strutureService = new StrutureServiceImpl();
        int[][] arr = {{0 , 0 , 1 , 0 , 0},{0 , 2 , 0 , 0 , 0},{0 , 0 , 0 , 3 , 0}};
        int[][] ints = strutureService.twoDimensionalArrayToSparseArray(arr,"newGame");

        for (int[] anInt : ints) {
            System.out.printf("%d\t%d\t%d\t\n", anInt[0], anInt[1], anInt[2]);
        }
    }

    @Test
    public void sparseArrayTotwoDimensionalArray(){
        StrutureServiceImpl strutureService = new StrutureServiceImpl();
        int[][] arr = {{3 , 5 , 3},{0 , 2 , 1},{1 , 1 , 2},{2, 3 , 3}};
        int[][] ints = strutureService.sparseArrayTotwoDimensionalArray("newGame");

       for (int i = 0;i < ints.length;i++){
           for (int j = 0;j < ints[i].length;j++){
               System.out.printf("%d\t",ints[i][j]);
           }
           System.out.println();
       }
    }

    @Test
    public void arrayQueueIn(){
        StrutureServiceImpl strutureService = new StrutureServiceImpl();
        int[] arr = {1,3,4};
        strutureService.arrayQueueUp(3,arr);
    }

    @Test
    public void arrayQueueOut(){
        StrutureServiceImpl strutureService = new StrutureServiceImpl();
        int[] arr = {1,3,4};
        strutureService.arrayQueueOut(3,arr);
    }

    @Test
    public void testStatic(){
        ClassLoader classLoader = ApiUtils.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(String.class.getClassLoader().getParent());
    }

    @Test
    public void circleArrayQueue(){
        StrutureServiceImpl strutureService = new StrutureServiceImpl();
        int[] arr = {1,3,4};



        strutureService.circleArrayQueue(arr.length+1,arr);
    }

    //快速排序
    @Test
    public void testQuickSort(){
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        AlgorithmsController algorithmsController = new AlgorithmsController();
        algorithmsController.quickSort(0,arr.length-1,arr);
        System.out.println(Arrays.toString(arr));
    }

}
