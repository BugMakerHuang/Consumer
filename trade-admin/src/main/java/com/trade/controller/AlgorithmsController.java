package com.trade.controller;

import java.sql.Timestamp;

/**
 * AlgorithsController
 * 算法是用来做什么的？
 * 算法他是用来高效的解决我们计算机处理的数据的一种方式。
 * 首先当我们去做一次数据排查，
 * 举个例子，我们要去查找student表当中 名字有'明'字的学生资料，一般情况下，我们会用遍历的方式，去走一边，这样的方式应对小数据组的时候是没有任何问题，但是应对大数据比如存在百万级，亿级数据，这种算法的执行时间有些偏长，还可能出现一些情况导致我们循环中断，又要重新排查
 * 显然不能满足我们的需求，所以为了解决这种情况，我们会采取更高效的算法来实现需求。
 * 算法的效率一般要从两个方面去考虑，一是满足空间效率，二是满足时间效率，一般分为几个梯度
 * 按复杂度从小(快)到大(慢)区分：
 *         f(n)                     阶                       函数名
 *          1                      O(1)                     常用函数
 *         2n+1                    O(n)                     线性函数
 *         2n^2+2n+2               O(n^2)                   二次函数
 *         2log2n+2                O(logn)                  对数函数
 *         2nlog2n+2n+2            O(nlogn)                 nlogn函数
 *         2n^3+2n+2               O(n^3)                   三次函数
 *         2^n                     O(2^n)                   指数函数
 * 正所谓鱼和熊掌不可兼得，要提高时间效率就必须牺牲空间内存，要保证存储效率就必须牺牲时间效率，论需求而定
 * 下面我先来对几个常用算法进行分析吧！
 **/
public class AlgorithmsController {
    //二分法查找法

    /**
     * 场景描述：
     * 现在有一个有序的数组arr，我们需要用二分法去找到我们的target值
     * 算法分析：
     * 1.我们的函数需要有两个形参，arr[]和 target，
     * 2.保证我们的数组是个有序数组
     * 3.mid值要随着数组二分后进行变化,例如 长度为 9 的数组二分以后mid下标为 4 ，假设我们的值比中间下标的值小,那么将会放在mid的左边，这时候算法需要对mid的下标进行重新计算,得出新下标为2,依次类推找到我们的target。
     * 4.循环体，用while作为循环体
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