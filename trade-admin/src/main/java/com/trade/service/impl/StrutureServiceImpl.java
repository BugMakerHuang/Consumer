package com.trade.service.impl;

import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author Ben.ZhenYu
 */
@Service
public class StrutureServiceImpl {
    /**
     * 例子 =      0 , 0 , 1 , 0 , 0
     *            0 , 2 , 0 , 0 , 0
     *            0 , 0 , 0 , 3 , 0
     *
     * 稀疏数组-》存入磁盘
     * 场景一：二维数组转稀疏数组
     *    1.遍历 原始 二维数组，得到有效数据的个数 num
     *    2.根据有效数组num就可以创建稀疏数组 soareseArr int[num+1][3]
     *    3.将二维数组的有效数据存入到稀疏数组中
     */
     public int[][] twoDimensionalArrayToSparseArray(int[][] arr,String name) throws IOException {
         //1.先遍历二维数组,得到非0数据的个数
         int sum = 0;
         for (int[] ints : arr) {
             for (int anInt : ints) {
                 if (anInt != 0) {
                     sum++;
                 }
             }
         }

         //创建稀疏数组
         int[][] soareseArr = new int[sum + 1][3];
         soareseArr[0][0] = arr.length;
         soareseArr[0][1] = arr[0].length;
         soareseArr[0][2] = sum;
         //用于记录执行次数
         int count = 0;

         //将二维数组有效值存入稀疏数组
         for (int i = 0;i < arr.length; i++){
             for(int j = 0; j < arr[i].length;j++){
                 if(arr[i][j] != 0){
                     count++;
                     soareseArr[count][0] = i;
                     soareseArr[count][1] = j;
                     soareseArr[count][2] = arr[i][j];
                 }
             }
         }
         if(!isStorage(soareseArr,name)){
             return null;
         }

         return soareseArr;
     }

    /**
     * 稀疏数组存入磁盘操作
     */
    private Boolean isStorage(int [][] sparseArray,String name) throws IOException {
        Boolean isStorage = false;
        FileWriter fileWriter = new FileWriter("C:\\Users\\DELL\\Desktop\\Consumer\\"+name+".data");
        try {
            for (int[] array:sparseArray){
                fileWriter.write(array[0]+"\t"+array[1]+"\t"+array[2]+"\t");
                fileWriter.write("\r\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
                isStorage = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isStorage;
    }


    /**
     * 数组从磁盘中取出
     */
    private int[][] isOutOfStorage(String name){
        int[][] sparseArray2=null;
        boolean isNotRead=false;
        BufferedReader bufferedReader=null;
        try {
            bufferedReader=new BufferedReader(new FileReader(new File("C:\\Users\\DELL\\Desktop\\Consumer\\"+name+".data")));
            String lineStr=null;
            int curCount=0;
            while ((lineStr=bufferedReader.readLine())!=null){
                String[] tempStr=lineStr.split("\t");
                if(!isNotRead){
                    sparseArray2=new int[Integer.parseInt(tempStr[2])+1][3];
                    sparseArray2[curCount][0]=Integer.parseInt(tempStr[0]);
                    sparseArray2[curCount][1]=Integer.parseInt(tempStr[1]);
                    sparseArray2[curCount][2]=Integer.parseInt(tempStr[2]);
                    curCount++;
                    isNotRead=true;
                }else {
                    sparseArray2[curCount][0]=Integer.parseInt(tempStr[0]);
                    sparseArray2[curCount][1]=Integer.parseInt(tempStr[1]);
                    sparseArray2[curCount][2]=Integer.parseInt(tempStr[2]);
                    curCount++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sparseArray2;
    }

    /**
     * 稀疏数组-》存入磁盘
     * 场景二：稀疏数组转二维数组
     *    1.先读取稀疏数组的第一行,根据第一行数据,创建原始的二维数组
     *    2.在读取几行稀疏数组后的几行数据,并赋给 原始的二维数组 即可
     */
    public int[][] sparseArrayTotwoDimensionalArray(String name){
        int[][] soareseArr = isOutOfStorage(name);
        //1.读取稀疏数组第一行第一列,创建二维数组
        int[][] twoDimensionalArray = new int[soareseArr[0][0]][soareseArr[0][1]];

        //2.遍历读取稀疏数组中的arr[i][2]的值
        for (int i = 1;i < soareseArr.length;i++){
           twoDimensionalArray[soareseArr[i][0]][soareseArr[i][1]]  = soareseArr[i][2];
        }

        return twoDimensionalArray;
    }
}
