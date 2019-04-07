package swea;

import java.util.*;

public class Solution1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int testCase = sc.nextInt();
 
        for (int i = 1; i <= testCase; i++) {
            int result = 0;
            int max = 0;
            int score[] = new int[101];
            int ary[] = new int[1000];
             
            int n = sc.nextInt();
             
            for(int j = 0; j < 1000; j++) {
                ary[j] = sc.nextInt();
            }
             
            for (int j = 0; j < ary.length; j++) {
                score[ary[j]]++;
            }
             
            for(int j =0; j < score.length; j++) {
                if(max < score[j]) {
                    max = score[j];
                    result = j;
                }else if(max == score[j]) {
                    if(result < j)
                        result = j;
                }
            }
             
            System.out.println("#" + i + " " + result);
             
        }
 
        sc.close();
    }
}