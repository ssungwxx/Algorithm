package swea;

import java.util.*;

public class Solution1206 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for(int i = 1; i <= 10 ; i++) {
            int n = sc.nextInt();
            int count = 0;
             
            int[] ary = new int[n];
            for(int j = 0; j < n ; j++) {
                ary[j] = sc.nextInt();
            }
             
            for(int j =2; j < ary.length-2; j++) {
                if(ary[j] > ary[j+1] && ary[j+2] < ary[j] && ary[j-1] < ary[j] && ary[j-2] < ary[j]) {
                    int check = ary[j-2];
                     
                    if(check < ary[j-1]) check = ary[j-1];
                    if(check < ary[j+1]) check = ary[j+1];
                    if(check < ary[j+2]) check = ary[j+2];
                     
                    count += ary[j] - check;
                }
            }
             
            System.out.println("#" + i + " " + count);
        }
        sc.close();
    }
 
}