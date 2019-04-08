package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int[] dp = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int date = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			if(i + date - 1 < N) {
				dp[i] += val;
				for (int j = i+date; j < dp.length; j++) {
					dp[j] = dp[j] < dp[i] ? dp[i] : dp[j];
				}
			}
			max = dp[i] > max ? dp[i] : max;
		}
		
		System.out.println(max);
		
	}
}