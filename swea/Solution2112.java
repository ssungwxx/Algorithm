package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2112 {
	private static int D;
	private static int W;
	private static int K;
	private static int[][] map;
	private static int[][] temp;
	private static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			temp = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					temp[i][j] = map[i][j];
				}
			}

			sb.append("#").append(tc).append(" ");
			min = Integer.MAX_VALUE;

			int pass = 0;
			for (int i = 0; i < W; i++) {
				if (test(i))
					pass++;
				else
					break;
			}
			if (pass == W || K ==1) {
				sb.append(0).append("\n");
			} else {
				solve(0, 0);
				sb.append(min).append("\n");
			}

		}
		System.out.print(sb.toString());
	}

	private static void solve(int n, int idx) {
		if (n >= 1) {
			int pass = 0;
			for (int i = 0; i < W; i++) {
				if (test(i))
					pass++;
				else
					break;
			}
			if (pass == W) {
				min = min > n ? n : min;
				return;
			}
		}
		if (n > min)
			return;
		if (idx == D)
			return;
		if (n > K)
			return;

		solve(n, idx + 1);
		Arrays.fill(map[idx], 1);
		solve(n + 1, idx+1);
		map[idx] = Arrays.copyOf(temp[idx], W);
		Arrays.fill(map[idx], 0);
		solve(n + 1, idx+1);
		map[idx] = Arrays.copyOf(temp[idx], W);

	}

	private static boolean test(int c) {
		for (int r = 0; r < D - K + 1; r++) {
			boolean flag = true;
			for (int i = 0; i < K; i++) {
				if (map[r][c] != map[r + i][c]) {
					flag = false;
					break;
				}
			}
			if (flag)
				return true;
		}
		return false;
	}
}
