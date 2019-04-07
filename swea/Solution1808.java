package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1808{
 
    private static int min;
    private static boolean[] arr;
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            min = Integer.MAX_VALUE;
            arr = new boolean[10];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < 10; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) arr[i] = true;
            }
             
            solve(N,0);
             
             
            sb.append("#").append(tc).append(" ");
            if(min == Integer.MAX_VALUE)
                sb.append("-1").append("\n");
            else
                sb.append(min).append("\n");
        }
         
        System.out.print(sb.toString());
    }
 
    private static void solve(int n, int cnt) {
        int temp = n;
        while(temp > 0 && arr[temp % 10]) {
            temp/= 10;
        }
         
        if(temp == 0) {
            min = (min > cnt + String.valueOf(n).length() + 1) ? cnt + String.valueOf(n).length() + 1 : min;
        }
         
        for (int i = 2; i < n/2; i++) {
            if(n % i == 0) {
                temp = i;
                while(temp > 0 && arr[temp % 10]) {
                    temp/= 10;
                }
                 
                if(temp == 0) {
                    solve(n / i , cnt + String.valueOf(i).length() + 1);
                }
            }
        }
    }
}