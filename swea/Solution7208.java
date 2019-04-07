package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7208 {

	static int N;
	static int[] color;
	static int[][] map;
	static int min;
	static int[] nc;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			N = Integer.parseInt(br.readLine().trim().trim());
			color = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			nc = new int[N];
			dfs(0, 0);

			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void dfs(int step, int cnt) {
		if (step == N) {
			if (min > cnt) {
				min = cnt;
			}
		} else {
			go: for (int i = 1; i <= 4; i++) {
				nc[step] = i;
				for (int j = 0; j < step; j++) {
					if (map[step][j] == 1 && nc[j] == i) {
						continue go;
					}
				}

				if (color[step] != nc[step]) {
					if (min > cnt + 1) {
						dfs(step + 1, cnt + 1);
					}
				} else {
					dfs(step + 1, cnt);
				}
			}
		}
	}
}