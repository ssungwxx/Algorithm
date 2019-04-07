package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution4613 {
    private static int N;
    private static int[][] memo;
    private static int min;
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
             
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            char[][] map = new char[N][M];
            memo = new int[N][3]; // W B R
            min = Integer.MAX_VALUE;
             
             
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] != 'W') {
                        memo[i][0]++;
                    }
                    if(map[i][j] != 'B') {
                        memo[i][1]++;       
                    }
                    if(map[i][j] != 'R') {
                        memo[i][2]++;
                    }
                }
            }
 
            solve(1, 0, memo[0][0]);
         
             
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
 
    private static void solve(int n, int color, int sum) {
        if(color == 2 && n == N) {
            min = min < sum ? min : sum;
            return;
        }
        if(n == N)return;
        if(color == 3) return;
        solve(n+1,color, sum + memo[n][color]);
        if(color < 2)
            solve(n+1,color + 1, sum + memo[n][color+1]);
         
    }
}