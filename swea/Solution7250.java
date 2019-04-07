package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7250 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			char[][] map = new char[N][M];
			Queue<info> q = new LinkedList<>();
			boolean[][][] Svisited = new boolean[N][M][K + 1];
			boolean[][] Vvisited = new boolean[N][M];
			boolean flag = false;
			info Antman = null;
			info Badman = null;
			int cnt = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String str = br.readLine().trim();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'S') {
						Antman = new info(i, j, K, 1, 'S');
						map[i][j] = 'A';
						Svisited[i][j][K] = true;
					} else if (map[i][j] == 'V') {
						Badman = new info(i, j, 0, 1, 'V');
						map[i][j] = 'A';
						Vvisited[i][j] = true;
					} else if (map[i][j] == 'F') {
						q.add(new info(i, j, 0, 1, 'F'));
					}
				}
			}

			if (Badman != null)
				q.add(Badman);
			q.add(Antman);

			loop: while (!q.isEmpty()) {
				info temp = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];

					switch (temp.sep) {
					case 'S':
						if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
							if (map[nx][ny] == 'A' && !Svisited[nx][ny][K]) {
								Svisited[nx][ny][K] = true;
								q.add(new info(nx, ny, K, temp.dep + 1, 'S'));
							} else if (map[nx][ny] == 'W' && temp.k > 0) {
								q.add(new info(nx, ny, temp.k - 1, temp.dep + 1, 'S'));
								Svisited[nx][ny][temp.k - 1] = true;
							} else if (map[nx][ny] == 'E') {
								cnt = temp.dep;
								break loop;
							}
						}
						break;
					case 'V':
						if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
							if ((map[nx][ny] == 'F' || map[nx][ny] == 'A') && !Vvisited[nx][ny]) {
								Vvisited[nx][ny] = true;
								q.add(new info(nx, ny, 0, temp.dep, 'V'));
							} else if (map[nx][ny] == 'E') {
								sb.append(-1);
								flag = true;
								break loop;
							}
						}
						break;
					case 'F':
						if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
							if (map[nx][ny] == 'A') {
								map[nx][ny] = 'F';
								q.add(new info(nx, ny, 0, temp.dep + 1, 'F'));
							}
						}
						break;
					}

				}

			}
			if (!flag && cnt == Integer.MAX_VALUE)
				sb.append(-1);
			if (cnt != Integer.MAX_VALUE)
				sb.append(cnt);

			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	static class info {
		int x;
		int y;
		int k;
		int dep;
		char sep;

		public info(int x, int y, int k, int dep, char sep) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.dep = dep;
			this.sep = sep;
		}

	}
}