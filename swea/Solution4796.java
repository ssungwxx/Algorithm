package swea;

import java.util.Scanner;

public class Solution4796 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
             
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int cnt = 0;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] < arr[i+1]) {
                    int j;
                    for (j = i +1; j < arr.length && arr[j] > arr[j-1]; j++);
                    int k;
                    for (k = j; k < arr.length && arr[k] < arr[k-1]; k++);
                    cnt += (k - j);
                }
            }
             
             
             
            System.out.println("#"+tc+" "+cnt);
        }
         
    }
}