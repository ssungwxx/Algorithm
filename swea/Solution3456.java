package swea;

import java.util.Scanner;

public class Solution3456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int n = sc.nextInt();
        for(int tc = 1; tc <=n; tc++) {
            int result = 0;
            int[] ary = new int[3];
            for(int i = 0; i < 3; i++) {
                ary[i] = sc.nextInt();
            }
             
             
            if(ary[0] == ary[1])
                result = ary[2];
            else if(ary[1] == ary[2])
                result = ary[0];
            else if(ary[0] == ary[2])
                result = ary[1];
             
            System.out.println("#"+ tc + " "+ result);
        }
         
        sc.close();
    }
}