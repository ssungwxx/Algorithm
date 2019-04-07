package swea;

import java.util.Arrays;
import java.util.Scanner;
 
public class Solution6719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            double result = 0;
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] M = new int[N];
            for(int i = 0 ; i < N ; i++) {
                M[i] = sc.nextInt();
            }
            Arrays.sort(M);
 
            for(int i = N - K ; i < N ; i++) {
                result = (result + (double)M[i]) / 2; 
            }
            System.out.println("#"+t +" " + String.format("%.6f", result));
        }
         
        sc.close();
    }
}