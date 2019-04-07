package swea;

import java.util.Scanner;

public class Solution1225 {
     
    static int n = 9;
    static int[] queue = new int[n];
    static int front, rear = 0;
     
    public static void enQueue(int a) {
        if(isFull())
            System.out.println("Queue is Full");
        else {
            rear = (rear+1) % n;
            queue[rear] = a;
        }
    }
     
    public static int deQueue() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        else {
            front = (front +1) % n;
            return queue[front];
        }
    }
     
    public static boolean isEmpty() {
        if(front == rear)
            return true;
        else
            return false;
    }
     
    public static boolean isFull() {
        if((rear+1) % n == front)
            return true;
        else
            return false;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int k = 0; k < 10; k++) {
            int tc = sc.nextInt();
             
            for(int i = 0; i < 8; i++) {
                enQueue(sc.nextInt());
            }
             
            int temp = -1;
            loop1:
            while(true) {
                for(int i = 1; i <= 5 ; i ++) {
                    temp = deQueue();
                    if(temp - i < 0 || temp - i == 0) {
                        enQueue(0);
                        break loop1;
                    }else {
                        enQueue(temp - i);
                    }
                }
            }
             
            System.out.print("#"+tc+" ");
            for(int i = 0; i < 8;i++) {
                System.out.print(deQueue() + " ");
            }
             
            System.out.println();
        }
         
        sc.close();
    }
     
     
}