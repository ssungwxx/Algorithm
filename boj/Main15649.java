package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649 {
	
	static int N;
	static int M;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			solve(i,1,String.valueOf(i));
			visited[i] = false;
		}
		
		
		
	}

	private static void solve(int now, int cnt,String val) {
		if(cnt == M) {
			System.out.println(val);
		}
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				solve(i, cnt +1, val + " " + i);
				visited[i] = false;
			}
		}
	}
}
