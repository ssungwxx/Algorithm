package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5653 {
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		for (int tc = 1; tc <= T; tc++) {
			map = new int[350][350];

			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			Queue<sepo> live = new LinkedList<>();

			// �ʱ���ġ �� ���� ����
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < M; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp > 0) { // ���� ������� 0���� Ŀ���� 0�� ��� ����
						map[150 + i][150 + j] = 1; // ���� ����ǥ��
						live.add(new sepo(150 + i, 150 + j, temp, 0, 0,0));
					}
				}
			}

			// K�ð����� ���
			for (int k = 0; k < K; k++) {
				//���̸Ա�
				while(true) {
					if (live.peek().time == k) {
						sepo s = live.poll();
						if (s.status == 0) {
							s.time++;
							s.age++;
							if (s.life == s.age) {
								s.status = 1;
							}
							live.add(s);
						} else if (s.status == 1) {
							s.time++;
							s.age++;
							// �������
							if (s.life * 2 != s.age) {
								live.add(s);								
							}
						}
					}else break;
				}

				// ���� ó��
				LinkedList<sepo> prepare = new LinkedList<>();
				for (sepo s : live) {
					if (s.status == 1) {
						for (int i = 0; i < 4; i++) {
							int nx = s.x + dx[i];
							int ny = s.y + dy[i];
							if(inRange(nx, ny) && map[nx][ny] == 0) {
								prepare.add(new sepo(nx, ny, s.life, 0, s.time,-1));
								map[nx][ny] = 2;
							}else if(inRange(nx, ny) && map[nx][ny] == 2) {
								// ������ǥ ���ĵ� ������ 
								for (sepo p : prepare) {
									if(p.x == nx && p.y == ny && p.life < s.life) {
										prepare.add(new sepo(nx, ny, s.life, 0, s.time,-1));
										prepare.remove(p);
										break;
									}
								}
							}
						}
					}
				}
				
				
				for (sepo p : prepare) {
					map[p.x][p.y] = 1;
					live.add(p);
				}
				
			}
			int cnt = 0;
			for (sepo s : live) {
				if(s.age >= 0) cnt++;
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}

	static class sepo {
		// status 0 ��Ȱ�� 1 Ȱ�� 2 ���Ĵ����
		int x, y, life, status, time,age;

		public sepo(int x, int y, int life, int status, int time, int age) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.status = status;
			this.time = time;
			this.age = age;
		}
	}
	
	static boolean inRange(int x, int y) {
		return x>=0 && x<map.length && y >=0 && y < map.length;
	}
}
