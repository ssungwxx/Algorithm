package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1012 {

	static boolean[][] map;
	static int M, N;
	static int[] nx = { 0, 0, 1, -1 };
	static int[] ny = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int cnt = 0;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			map = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = true;
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]) {
						solve(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	public static void solve(int x, int y) {
		if (!map[x][y])
			return;

		map[x][y] = false;
		for (int i = 0; i < 4; i++) {
			if (x + nx[i] >= 0 && x + nx[i] < M && y + ny[i] >= 0 && y + ny[i] < N) {
				solve(x + nx[i], y + ny[i]);
			}
		}
	}
}
