package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class Solution5648 {
	public static void main(String[] args) throws Exception {
		// 0 우 1 좌 2 상 3 하
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		ArrayList<wonja> list;
		
		int[][] map = new int[4001][4001];
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());

			list = new ArrayList<>();


			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int vec = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
				list.add(new wonja(x, y, vec, K, true));

			}

			int total = 0;

			boolean flag = true; // 탈출조건

			// 반복
			while (flag) {
				flag = false;
				
				for (wonja w : list) {
					map[w.x][w.y] = 0;
				}

				// 한칸 전진
				for (wonja w : list) {
					if (w.l) {
						int nx = w.x + dx[w.v];
						int ny = w.y + dy[w.v];

						// 범위초과
						if (!inRange(nx, ny)) {
							w.l = false;
							continue;
						}

						if (map[nx][ny] == 0) {
							map[nx][ny] = 1;
							w.x = nx;
							w.y = ny;
						} else {
							if (map[nx][ny] == 1) {
								// 가장먼저온 원자 폭발
								for (wonja w2 : list) {
									if (w2.l && w2.x == nx && w2.y == ny) {
										total += w2.e;
										w2.l = false;
										break;
									}
								}
								// 그다음온 원자 폭발
								total += w.e;
								w.l = false;
							} else { // 2이상일경우
								total += w.e;
								w.l = false;
							}
							map[nx][ny]++;
						}

					}

				}
				// 맵 재 설정
				for (wonja w : list) {
					map[w.x][w.y] = 0;
				}

				for (wonja w : list) {
					if (w.l) {
						map[w.x][w.y] = 1;
						flag = true;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		System.out.print(sb.toString());
	}

	static class wonja {
		int x, y, v, e;
		boolean l;

		public wonja() {
		}

		public wonja(int x, int y, int v, int e, boolean l) {
			this.x = x;
			this.y = y;
			this.v = v;
			this.e = e;
			this.l = l;
		}
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x <= 4000 && y >= 0 && y <= 4000;
	}
}
