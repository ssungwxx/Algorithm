package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {

	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int time;
	static int last;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		time = 0;
		last = 0;

		
		while(findcheese()) {
			airbfs(0, 0);
			time++;
		}

		System.out.println(time);
		System.out.println(last);
	}

	public static void airbfs(int x, int y) {
		visited = new boolean[N + 2][M + 2];
		Queue<pair> airQ = new LinkedList<>();
		airQ.add(new pair(x, y));

		while (!airQ.isEmpty()) {
			pair temp = airQ.poll();
			visited[temp.x][temp.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx >= 0 && nx <= N + 1 && ny >= 0 && ny <= M + 1 && !visited[nx][ny]) {
					if (map[nx][ny] == 0) {
						airQ.add(new pair(nx, ny));
						visited[nx][ny] = true;
					} else if (map[nx][ny] == 1) {
						map[nx][ny] = 0;
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

	public static boolean findcheese() {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		if (cnt > 0) {
			last = cnt;
			return true;
		} else
			return false;
	}

	static class pair {
		int x;
		int y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
