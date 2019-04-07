package swea;

import java.util.*;

public class Solution5431 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int tc = sc.nextInt();
         
        for(int i = 1; i <= tc; i++) {
             
            int total = sc.nextInt();
            int done = sc.nextInt();
             
            int[] ary = new int[total];
             
            for (int j = 0; j < done; j++) {
                ary[sc.nextInt() - 1] = 1;
            }
             
         
            System.out.printf("#" + i + " ");
            for (int j = 0; j < ary.length; j++) {
                if(ary[j] == 0) {
                    System.out.print((j+1) + " ");
                }
            }
            System.out.println();
        }
         
        sc.close();
    }
 
}