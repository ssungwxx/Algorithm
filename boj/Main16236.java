package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236 {
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };

		N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		HashMap<Integer, Integer> hm = new HashMap<>();
		Shark shark = new Shark(-1, -1, 0, 0, 0);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0, 0);
					map[i][j] = 0;
				} else if (map[i][j] > 0) {
					if (hm.containsKey(map[i][j]))
						hm.put(map[i][j], hm.get(map[i][j]) + 1);
					else
						hm.put(map[i][j], 1);
				}
			}
		}
		while (true) {
			int cnt = 0;
			for (int i = shark.size - 1; i > 0; i--) {
				if (hm.containsKey(i))
					cnt += hm.get(i);
			}
			if (cnt == 0) {
				System.out.println(shark.move);
				break;
			}
			Queue<Shark> q = new LinkedList<>();
			Queue<Shark> ns = new LinkedList<>();
			q.add(new Shark(shark.x, shark.y, shark.size, shark.move, shark.eat));
			boolean[][] visited = new boolean[N][N];
			while (!q.isEmpty()) {
				Shark temp = q.poll();
				visited[temp.x][temp.y] = true;
				for (int i = 0; i < 4; i++) {
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];
					if (inRange(nx, ny) && map[nx][ny] <= temp.size && !visited[nx][ny]) {
						if (map[nx][ny] + 1 == temp.size) {
							if (temp.eat + 1 == temp.size) {
								ns.add(new Shark(nx, ny, temp.size + 1, temp.move + 1, 0));
							} else {
								ns.add(new Shark(nx, ny, temp.size, temp.move + 1, temp.eat + 1));
							}
						} else if (map[nx][ny] != 0 && map[nx][ny] < temp.size) {
							if (temp.eat + 1 == temp.size) {
								ns.add(new Shark(nx, ny, temp.size + 1, temp.move + 1, 0));
							} else {
								ns.add(new Shark(nx, ny, temp.size, temp.move + 1, temp.eat + 1));
							}
						} else { // 0이거나 크기가 같은경우
							if (ns.isEmpty()) {
								q.add(new Shark(nx, ny, temp.size, temp.move + 1, temp.eat));
								visited[nx][ny] = true;
							}
						}
					}
				}
			}

			if(ns.isEmpty()) {
				System.out.println(shark.move);
				break;
			}
			shark = ns.poll();
			while (!ns.isEmpty()) {
				Shark temp = shark;
				Shark other = ns.poll();
				if (other.move <= temp.move && other.x < temp.x) {
					shark = other;
				} else if (other.move <= temp.move && other.x == temp.x && other.y < temp.y) {
					shark = other;
				}
			}
			hm.put(map[shark.x][shark.y], hm.get(map[shark.x][shark.y]) - 1);
			map[shark.x][shark.y] = 0;
		}

	}

	static class Shark {
		int x, y, size, move, eat;

		public Shark(int x, int y, int size, int move, int eat) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.move = move;
			this.eat = eat;
		}
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
