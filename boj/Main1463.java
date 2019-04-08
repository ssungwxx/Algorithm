package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1463 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+5];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for (int i = 2; i < dp.length; i++) {
			if(i - 1 >= 0) {
				if(dp[i] == 0)
					dp[i] = dp[i-1] + 1;
				else if(dp[i] > dp[i-1] + 1)
					dp[i] = dp[i-1] + 1;
			}
			if(i % 2 == 0) {
				if(dp[i] == 0)
					dp[i] = dp[i/2] + 1;
				else if(dp[i] > dp[i/2] + 1)
					dp[i] = dp[i/2] + 1;
			}
			if(i % 3 == 0) {
				if(dp[i] == 0)
					dp[i] = dp[i/3] + 1;
				else if(dp[i] > dp[i/3] + 1)
					dp[i] = dp[i/3] + 1;
			}
		}
		
		System.out.println(dp[N]);
	}
}
