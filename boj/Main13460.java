package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13460 {

	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static pair whereB;
	private static pair whereR;
	private static int min;
	private static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'B')
					whereB = new pair(i, j, 0);
				else if (map[i][j] == 'R')
					whereR = new pair(i, j, 1);
			}
		}
		min = 11;
		solve(whereB.x, whereB.y, whereR.x, whereR.y, 0);
		if (min == 11)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void solve(int Bx, int By, int Rx, int Ry, int n) {
		if (n == 11)
			return;
		if (n > min)
			return;
		if (n > 0) {
			if (map[whereB.x][whereB.y] == 'O')
				return;
			if (map[whereR.x][whereR.y] == 'O') {
				min = min > n ? n : min;
				return;
			}
		}
		for (int i = 0; i < 4; i++) {
			Queue<pair> q = new LinkedList<>();

			q.add(new pair(whereB.x, whereB.y, 0));
			q.add(new pair(whereR.x, whereR.y, 1));
			q.add(new pair(whereB.x, whereB.y, 0)); // 어느쪽이 먼저 출발해도 상관없도록 둘다 들어가도 다음칸이 변경되어 하나 소멸

			while (!q.isEmpty()) {
				pair p = q.poll();

				if (map[p.x][p.y] != 'O') {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (map[nx][ny] == '.') {
						q.add(new pair(nx, ny, p.sep));
						if (p.sep == 0) {
							map[p.x][p.y] = '.';
							map[nx][ny] = 'B';
							whereB.x = nx;
							whereB.y = ny;
						} else { // sep == 1
							map[p.x][p.y] = '.';
							map[nx][ny] = 'R';
							whereR.x = nx;
							whereR.y = ny;
						}
					} else if (map[nx][ny] == 'O') {
						if (p.sep == 0) {
							map[p.x][p.y] = '.';
							whereB.x = nx;
							whereB.y = ny;
						} else { // sep == 1
							map[p.x][p.y] = '.';
							whereR.x = nx;
							whereR.y = ny;
						}
					}
				}
			}
			solve(whereB.x, whereB.y, whereR.x, whereR.y, n + 1);
			if (map[whereB.x][whereB.y] != 'O')
				map[whereB.x][whereB.y] = '.';
			map[Bx][By] = 'B';
			whereB.x = Bx;
			whereB.y = By;
			if (map[whereR.x][whereR.y] != 'O')
				map[whereR.x][whereR.y] = '.';
			map[Rx][Ry] = 'R';
			whereR.x = Rx;
			whereR.y = Ry;

		}

		return;
	}

	static class pair {
		int x, y, sep;

		public pair(int x, int y, int sep) { // 0 Blue 1 Red
			this.x = x;
			this.y = y;
			this.sep = sep;
		}
	}
}
