package com.trade.dao.entity;


/**
 * @author Ben.ZhenYu
 */
public class ArrayQueue {

    private int    front;
    private int    rear;
    private int[]  queue;
    private int    maxSize;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = -1;
        rear =  -1;
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
          this.rear++;
          this.queue[rear] = i;
    }

    /**
     * 判断队列是否已经满了
     */
    private boolean isFull(){
        return this.rear == this.maxSize-1;
    }

    /**
     * 判断队列是否为空
     */
    private boolean isEmpty(){
        return this.rear == this.front;
    }

    /**
     * 出栈 or 获取队列
     */
    public int queueOut(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        this.front++;
        return this.queue[front];
    }

    /**
     * 展示队列
     */
    public void showQueue(){
        for (int i = 0;i < queue.length;i++){
            System.out.printf("%d\t",queue[i]);
        }
    }
}
