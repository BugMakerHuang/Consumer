package com.trade.dao.entity;


/**
 * @author ZhenYu.Ben
 *
 *      * 使用数组模拟环形队列的思路分析
 *      *
 *      * 1.front变量的含义是做一个调整:front就指向队列的第一个元素,也就是说arr[front]就是队列的第一个元素,front 的初始值为 0;
 *      * 2.rear变量的含义做一个调整:rear指向队列的最后一个元素的后一个位置,因为希望空出一个空间作为约定,比如当 maxSize为 3 的时候有效数组个数为 2, rear 的初始值为 0;
 *      * 3.当队列满时,条件是 (rear + 1)%maxSize = front 【满】;
 *      * 4.当队列为空的条件,rear == front 空;
 *      * 5.当我们这样分析，队列中有效的数据的个数 (rear + maxSize - front)%maxSize  例如: rear = 1 front = 0;
 *      * 6.我们就可以在原来的队列上修改得到,一个环形队列;
 *
 */
public class CircleArrayQueue {
    private int    front;
    private int    rear;
    private int[]  queue;
    private int    maxSize;

    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;
        rear =  0;
    }

    /**
     * 判断队列是否已经满了
     */
    private boolean isFull(){
        return (this.rear + 1) % maxSize == this.front;
    }

    /**
     * 判断队列是否为空
     */
    private boolean isEmpty(){
        return this.rear == this.front;
    }

    /**
     * 入栈
     */
    public void queueUp(int i){
        //判断是否队列已经满
        if(isFull()){
            System.out.println("队列满");
            return;
        }
        //直接将数据加入
        queue[rear] = i;
        //将 rear 后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 出栈 or 获取队列
     */
    public int queueOut(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }

        //这里需要分析出front是指向队列的第一个元素
        //1.先把 front 对应的值保留到一个临时变量
        //2.将 front 后移
        //3.将临时保存的变量返回
        int value = queue[front];
        front = (front + 1) % maxSize;

        return value;
    }


    /**
     * 展示队列
     */
    public void showQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        // 思路 : 从front开始遍历,遍历多少个元素
        for (int i = front;i < front + size();i++){
            System.out.printf("arr[%d] = %d\n", i % maxSize , queue[i%maxSize]);
        }
    }

    /**
     *   求出当前队列有效数据个数
     */
    public int size(){
        return (rear + maxSize - front)%maxSize;
    }

    /**
     * 显示头元素
     */
     public int headQueue(){
         //判断队列是否为空
         if(isEmpty()){
             throw new RuntimeException("队列为空");
         }

         return queue[front];
     }
}
