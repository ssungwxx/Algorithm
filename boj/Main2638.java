package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2638 {

	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

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
		
		int time = 0;
		while(searchCheese()) {
			visited = new int[N + 2][M + 2];
			bfs();
			time++;
		}
		System.out.println(time);
	}

	public static void bfs() {
		Queue<pair> q = new LinkedList<>();

		q.add(new pair(0, 0));
		visited[0][0] = 1;

		while (!q.isEmpty()) {
			pair temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];

				if (nx >= 0 && nx <= N + 1 && ny >= 0 && ny <= M + 1 && map[nx][ny] == 0 && visited[nx][ny] == 0) {
					q.add(new pair(nx, ny));
					visited[nx][ny]++;
				}
				if (nx >= 0 && nx <= N + 1 && ny >= 0 && ny <= M + 1 && map[nx][ny] == 1) {
					visited[nx][ny]++;
					if (visited[nx][ny] == 2)
						map[nx][ny] = 0;
				}

			}

		}
	}

	public static boolean searchCheese() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 1) {
					return true;
				}
			}
		}
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
