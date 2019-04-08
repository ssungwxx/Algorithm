package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	private static ArrayList<pair> virus;
	private static ArrayList<pair> space;
	private static int[][] map;
	private static int N;
	private static int M;
	private static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virus = new ArrayList<>();
		space = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new pair(i, j));
				else if (map[i][j] == 0) {
					space.add(new pair(i, j));
				}
			}
		}

		max = 0;

		boolean[] temp = new boolean[space.size()];
		solve(0, 0, temp);

		System.out.println(max);
	}

	private static void solve(int pnt, int n, boolean[] check) {
		if (n == 3) {
			int[][] mapCopy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					mapCopy[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < check.length; i++) {
				if (check[i]) {
					mapCopy[space.get(i).x][space.get(i).y] = 1;
				}
			}

			boolean[][] visited = new boolean[N][M];
			Queue<pair> q = new LinkedList<>();
			for (pair p : virus) {
				q.add(p);
				visited[p.x][p.y] = true;
			}

			while (!q.isEmpty()) {
				pair p = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (inRange(nx, ny) && !visited[nx][ny]) {
						if (mapCopy[nx][ny] == 0) {
							mapCopy[nx][ny] = 2;
							visited[nx][ny] = true;
							q.add(new pair(nx, ny));
						}
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mapCopy[i][j] == 0)
						cnt++;
				}
			}

			max = max < cnt ? cnt : max;
			return;

		}
		if (pnt == space.size())
			return;

		boolean[] temp1 = Arrays.copyOf(check, check.length);
		solve(pnt + 1, n, temp1);
		boolean[] temp2 = Arrays.copyOf(check, check.length);
		temp2[pnt] = true;
		solve(pnt + 1, n + 1, temp2);
		temp2[pnt] = false;

	}

	static class pair {
		int x, y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
