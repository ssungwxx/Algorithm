package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution3234 {
    private static int[][] map;
    private static int N;
    private static int[] arr;
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            map = new int[1<< N][1<< N];
 
            sb.append("#").append(tc).append(" ").append(solve(0,0,0,0,0)).append("\n");
        }
        System.out.print(sb.toString());
    }
 
    private static int solve(int n, int left, int right, int l, int r) {
        if(n == N) return 1;
         
        if(map[l][r] > 0) return map[l][r];
         
        int ans = 0;
         
        for (int i = 0; i < N; i++) {
            if((l & (1 << i)) == 0 && (r & (1 << i)) == 0 ) {
                int temp = right + arr[i];
                if(temp <= left) ans += solve(n + 1, left, temp, l, r | (1 << i));
                ans += solve(n + 1, left + arr[i], right, l | (1 << i), r);
            }
             
        }
        map[l][r] = ans;
        return map[l][r];
    }
}