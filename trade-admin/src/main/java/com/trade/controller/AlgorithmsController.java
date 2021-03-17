package com.trade.controller;

import java.sql.Timestamp;

public class AlgorithmsController {
    /**
     * 场景描述：
     * 现在有一个有序且不重复的数组 arr ，我们需要用二分法去找到我们的target值
     * 算法分析：
     * 1.我们的函数需要有两个形参，arr[]和 target，
     * 2.mid值要随着数组二分后进行变化,例如 长度为 9 的数组二分以后mid下标为 4 ，假设我们的值比中间下标的值小,那么将会放在mid的左边，这时候算法需要对mid的下标进行重新计算,得出新下标为2,依次类推找到我们的target。
     * 3.循环体，用while作为循环体
     **/
    public static Integer binarySearch(int arr[], int target) {
        //我们的low值为初始值,high值为初始长度为数组总长度
        int low = 0;
        int high = arr.length - 1;
        System.out.println("开始前" + new Timestamp(System.currentTimeMillis()));
        while (low <= high) {

            //mid值将数组二分
            int mid = low + (high - low) / 2;

            //分别比对target和arr[mid]的大小,target大则在右半边,反之则在左半边,挖除mid的值;
            if (target < arr[mid]) {

                //下标最大值为当前mid的前一位
                high = mid - 1;

            } else if (target > arr[mid]) {

                //下标最大值为当前mid的后一位
                low = mid + 1;

            } else {

                //当 target == arr[mid]
                System.out.println("开始后" + new Timestamp(System.currentTimeMillis()));
                return mid;

            }
        }

        return -1;

    }


    
}