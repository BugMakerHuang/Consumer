package com.trade.controller;

import com.trade.config.TreeNode;
import com.trade.dao.entity.Agent;
import com.trade.dao.entity.ArrayQueue;
import com.trade.dao.entity.Person;
import com.trade.dao.entity.UserEntity;
import com.trade.service.impl.StrutureServiceImpl;
import com.trade.utils.ApiUtils;
import io.swagger.annotations.Api;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.sql.Timestamp;
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

    @Test
    public void hammingDistanceTest(){
        AlgorithmsController algorithmsController = new AlgorithmsController();
        int i = algorithmsController.hammingDistance(93, 73);
        System.out.println(i);
    }

    @Test
    public void mergeTreesTest(){
        AlgorithmsController algorithmsController = new AlgorithmsController();
        /*************节点1****************/
        TreeNode rootNode1 = new TreeNode(1);
        rootNode1.left  = new TreeNode(3);
        rootNode1.right = new TreeNode(2);
        rootNode1.left.left = new TreeNode(5);
        /************节点2****************/
        TreeNode rootNode2 = new TreeNode(2);
        rootNode2.left  = new TreeNode(1);
        rootNode2.right = new TreeNode(3);
        rootNode2.left.right = new TreeNode(4);
        rootNode2.right.right = new TreeNode(7);
        /************合并二叉树*************/
        TreeNode treeNode = algorithmsController.mergeTrees(rootNode1, rootNode2);

        System.out.println(treeNode);
    }

    @Test
    public void invertTreeTest(){
        AlgorithmsController algorithmsController = new AlgorithmsController();
        /*************节点1****************/
        TreeNode rootNode1 = new TreeNode(4);
        rootNode1.left  = new TreeNode(2);
        rootNode1.right = new TreeNode(7);
        rootNode1.left.left = new TreeNode(1);
        rootNode1.left.right = new TreeNode(3);
        rootNode1.right.left = new TreeNode(6);
        rootNode1.right.right = new TreeNode(9);
        /************合并二叉树*************/
        TreeNode treeNode = algorithmsController.invertTree(rootNode1);

        System.out.println(treeNode);
    }


    //浅拷贝
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        //新建一个对象
        UserEntity userEntity = new UserEntity(1,"震宇","24289", new Timestamp(System.currentTimeMillis()));
        userEntity.setAgent("广东省","深圳市");

        UserEntity clone = userEntity.clone();

        int hashCode1 = userEntity.getUsername().hashCode();
        int hashCode = clone.getUsername().hashCode();


        clone.setAgent("广东省","广州市");
        System.out.println(clone);
        System.out.println(userEntity);
        System.out.println(hashCode == hashCode1);
    }

    //深拷贝
    @Test
    public void testShallowClone() throws Exception{
        Person p1 = new Person("zhangsan",21);
        p1.setAddress("湖北省", "武汉市");
        Person p2 = (Person) p1.clone();
        System.out.println("p1:"+p1);
        System.out.println("p1.getPname:"+p1.getPname().hashCode());

        System.out.println("p2:"+p2);
        System.out.println("p2.getPname:"+p2.getPname().hashCode());

        p1.display("p1");
        p2.display("p2");
        p2.setAddress("湖北省", "荆州市");
        p2.setPname("23");
        System.out.println("将复制之后的对象地址修改：");
        p1.display("p1");
        p2.display("p2");
    }

}
