package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution5213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        long[] arr = new long[1000001];
 
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= (arr.length-1) / i; j++) {
                if(i % 2 == 1)
                    arr[i*j] += i;
            }
            arr[i] +=arr[i-1];
        }
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
             
 
            System.out.println("#" + tc + " "+ (arr[R] - arr[L-1]));
        }
    }
}