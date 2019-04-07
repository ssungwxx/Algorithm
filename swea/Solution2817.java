package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution2817 {
     
    static int N,K;
    static int[] arr;
    static int cnt;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine(), " ");
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
             
            cnt = 0;
            solve(0,0);
            System.out.println("#" + tc + " " + cnt);
        }
    }
 
    private static void solve(int idx, int sum) {
        if(idx == N) {
            if(sum == K) cnt ++;
            return;
        }else {
            solve(idx+1,sum+arr[idx]);
            solve(idx+1,sum);
        }
         
    }
}