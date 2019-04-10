package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main3190 {
	private static int N;

	public static void main(String[] args) throws Exception {

		// 0 �� 1 �� 2 �� 3 ��
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());
		int K = Integer.parseInt(br.readLine().trim());

		int[][] map = new int[N + 1][N + 1];

		LinkedList<pair> snake = new LinkedList<>(); // ����ġ ������ ��ũ�� ����Ʈ;
		snake.add(new pair(1, 1)); // �������� 1,1
		map[1][1] = 1; // ����ġ ǥ��
		int vec = 0; // �� �������

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 2; // ��� ��ġ ���� ����� 2
		}

		int L = Integer.parseInt(br.readLine().trim());
		int[] check = new int[L];
		char[] turn = new char[L];

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			check[i] = Integer.parseInt(st.nextToken());
			;
			turn[i] = st.nextToken().charAt(0);
		}

		int time = 0; // �ɸ��ð�
		int flag = 0;

		while (true) { // �� ������ Ż��
			time++;

			int nx = snake.get(snake.size() - 1).x + dx[vec];
			int ny = snake.get(snake.size() - 1).y + dy[vec];
			if (!inRange(nx, ny)) {
				break;
			} else if (map[nx][ny] == 0) {
				map[snake.get(0).x][snake.get(0).y] = 0;
				map[nx][ny] = 1;
				snake.add(new pair(nx, ny));
				snake.remove(0);
			} else if (map[nx][ny] == 1) {
				break;
				
			} else if (map[nx][ny] == 2) {
				map[nx][ny] = 1;
				snake.add(new pair(nx, ny));
			}

			if (flag < check.length && check[flag] == time) {
				if (turn[flag] == 'L') { // �������� 90�� ȸ��
					vec += 1;
					if (vec == 4)
						vec = 0;
				} else { // ���������� 90�� ȸ��
					vec -= 1;
					if (vec == -1)
						vec = 3;
				}
				flag++;
			}
			
			
		}

		System.out.println(time);
	}

	static class pair {
		int x, y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		return x > 0 && x <= N && y > 0 && y <= N;
	}
}
