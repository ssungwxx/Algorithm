package swea;

import java.util.*;

public class Solution1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[100][100];
         
 
        for (int n = 0; n < 10; n++) {
            int max = Integer.MIN_VALUE;
            int tc = sc.nextInt();
 
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
 
            int iSum[] = new int[100];
            int jSum[] = new int[100];
            int cross1 = 0;
            int cross2 = 0;
 
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    iSum[i] += map[i][j];
                    jSum[i] += map[j][i];
                }
 
                cross1 += map[i][i];
                cross2 += map[99 - i][99 - i];
 
            }
 
            for (int i = 0; i < 100; i++) {
                max = (max < iSum[i]) ? iSum[i] : max;
                max = (max < jSum[i]) ? jSum[i] : max;
            }
 
            max = (max < cross1) ? cross1 : max;
            max = (max < cross2) ? cross2 : max;
 
            System.out.println("#" + tc + " " + max);
        }
 
        sc.close();
    }
}