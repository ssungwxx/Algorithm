package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main2283 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine().trim());
        int[][] house = new int[N][3];
        int[][] dp = new int[N][3];
         
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];
         
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i-1][(j+1)%3] + house[i][j], dp[i-1][(j+2)%3] + house[i][j]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = min < dp[N-1][i] ? min : dp[N-1][i];
        }
         
        System.out.println(min);
         
    }
}