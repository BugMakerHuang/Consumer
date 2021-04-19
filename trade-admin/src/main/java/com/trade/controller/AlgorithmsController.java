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

    private  int pivotIndex(int startIndex,int lastIndex,int[] arr){
        //选举基准值，默认为数组的第一个索引下标
        int pivot = arr[startIndex];
        int left  = startIndex;
        int right = lastIndex;

        //开始循环
        while (left != right){
            //数组开始查询，先从后往前查，arr[right] >= pivot 的时候 指针right向左移动一位， arr[right] < pivot的时候,right指针保持不动,切换到left指针
            while (left < right && arr[right]>= pivot){
                right--;
            }
            //当arr[right] < pivot的时候,切换到left指针,当left指针的值小于pivot的时候，left指针向右移动一位,反之则left和right的值进行交换
            while (left < right && arr[left] <= pivot){
                left++;
            }
            if(left < right){
                int temp   = arr[left];
                arr[left]  = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    public void quickSort(int startIndex,int lastIndex,int[] arr){
        if(startIndex >= lastIndex){
            return;
        }

        int pivotIndex = pivotIndex(startIndex, lastIndex, arr);
        quickSort(startIndex,pivotIndex-1,arr);
        quickSort(pivotIndex+1,lastIndex,arr);
    }
}