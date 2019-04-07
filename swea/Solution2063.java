package swea;

import java.util.Scanner;

public class Solution2063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int n = sc.nextInt();
        int ary[] = new int[n];
         
        for(int i = 0; i < n ; i++) {
            ary[i] = sc.nextInt();
        }
         
        for(int i = ary.length-1; i > 0; i--) {
            for(int j = 0; j < ary.length - 1; j++) {
                if(ary[j] < ary[j+1]) {
                    int temp = ary[j+1];
                    ary[j+1] = ary[j];
                    ary[j] = temp;
                }
                 
            }
        }
         
        System.out.println(ary[n/2]);
         
        sc.close();
    }
}