package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697{

	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		visited = new boolean[2000002];
		min = Integer.MAX_VALUE;
		if (N == K)
			min = 0;
		else
			solve(N, K, 0);

		System.out.println(min);
	}

	public static void solve(int n, int k, int move) {
		Queue<pair> q = new LinkedList<>();

		q.add(new pair(n, move));

		while (!q.isEmpty()) {
			pair temp = q.poll();
			int nn = temp.N;

			if (nn == k) {
				min = (temp.move < min) ? temp.move : min;
				break;
			}
			
			if(nn < k) {
				if (nn + 1 < visited.length && !visited[nn + 1]) {
					q.add(new pair(nn + 1, temp.move + 1));
					visited[nn + 1] = true;
				}
				if (nn * 2 < visited.length && !visited[nn * 2]) {
					q.add(new pair(nn * 2, temp.move + 1));
					visited[nn * 2] = true;
				}		
				if (nn - 1 >= 0 && !visited[nn - 1]) {
					q.add(new pair(nn - 1, temp.move + 1));
					visited[nn - 1] = true;
				}	
			}else {
				if (nn - 1 >= 0 && !visited[nn - 1]) {
					q.add(new pair(nn - 1, temp.move + 1));
					visited[nn - 1] = true;
				}				
			}

		}
	}

	static class pair {
		int N;
		int move;

		public pair(int n, int move) {
			N = n;
			this.move = move;
		}
	}
}
