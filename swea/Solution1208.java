package swea;

import java.util.*;

public class Solution1208 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int i = 1; i <= 10; i++) {
            int dump = sc.nextInt();
             
            int[] ary = new int[100];
            int count = 0;
             
            for(int j = 0; j < 100; j++) {
                ary[j] = sc.nextInt();
            }
             
            for(int j = 0; j < dump; j++) {
                Arrays.sort(ary);
                ary[99]--;
                ary[0]++;
            }
             
            Arrays.sort(ary);
            count = ary[99] - ary[0];
             
             
            System.out.println("#" + i + " " + count);
        }
         
        sc.close();
    }
 
}