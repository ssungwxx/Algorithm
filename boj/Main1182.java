package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1182 {
	
	static int cnt = 0;
	static int S,N;
	static int[] set;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		set = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			set[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,0,0);

		System.out.println(cnt);
	}

	private static void solve(int idx, int sum,int check) {
		if(idx > N-1) {
			if(sum == S && check > 0) cnt++;
			return;
		}
		
		solve(idx+1,sum,check);
		solve(idx+1,sum+set[idx],check+1);
	}
}
