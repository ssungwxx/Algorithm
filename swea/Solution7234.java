package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7234 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dx = { 0, 0, 0, 0, -1, 1, -2, 2 };
		int[] dy = { -1, 1, -2, 2, 0, 0, 0, 0 };

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			int max = 0;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y]++;
				for (int j = 0; j < 8; j++) {
					int tempX = x + dx[j];
					int tempY = y + dy[j];
					if (tempX >= 1 && tempX < N + 1 && tempY >= 1 && tempY < N + 1) {
						map[tempX][tempY]++;
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] > max) {
						max = map[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}