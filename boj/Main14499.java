package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14499 {

	private static int N;
	private static int M;
	private static int[] dice;
	private static int[] dx = { 0, 0, 0, -1, 1 };
	private static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dice = new int[7];
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < K; i++) {
			
			String cmd = st.nextToken();
			int[] temp = new int[7];
			int nx = 0;
			int ny = 0;
			switch (cmd) {
			case "1":
				nx = x + dx[1];
				ny = y + dy[1];
				if (inRange(nx, ny)) {
					temp[1] = dice[3];
					temp[2] = dice[2];
					temp[3] = dice[6];
					temp[4] = dice[1];
					temp[5] = dice[5];
					temp[6] = dice[4];
					dice = temp.clone();
					x = nx;
					y = ny;
					if(map[x][y] == 0) {
						map[x][y] = dice[1];
					}else {
						dice[1] = map[x][y];
						map[x][y] = 0;
					}
					System.out.println(dice[6]);
				}
				break;
			case "2":
				nx = x + dx[2];
				ny = y + dy[2];
				if (inRange(nx, ny)) {
					temp[1] = dice[4];
					temp[2] = dice[2];
					temp[3] = dice[1];
					temp[4] = dice[6];
					temp[5] = dice[5];
					temp[6] = dice[3];
					dice = temp.clone();
					x = nx;
					y = ny;
					if(map[x][y] == 0) {
						map[x][y] = dice[1];
					}else {
						dice[1] = map[x][y];
						map[x][y] = 0;
					}
					System.out.println(dice[6]);
				}
				break;
			case "3":
				nx = x + dx[3];
				ny = y + dy[3];
				if (inRange(nx, ny)) {
					temp[1] = dice[2];
					temp[2] = dice[6];
					temp[3] = dice[3];
					temp[4] = dice[4];
					temp[5] = dice[1];
					temp[6] = dice[5];
					dice = temp.clone();
					x = nx;
					y = ny;
					if(map[x][y] == 0) {
						map[x][y] = dice[1];
					}else {
						dice[1] = map[x][y];
						map[x][y] = 0;
					}
					System.out.println(dice[6]);
				}
				break;
			case "4":
				nx = x + dx[4];
				ny = y + dy[4];
				if (inRange(nx, ny)) {
					temp[1] = dice[5];
					temp[2] = dice[1];
					temp[3] = dice[3];
					temp[4] = dice[4];
					temp[5] = dice[6];
					temp[6] = dice[2];
					dice = temp.clone();
					x = nx;
					y = ny;
					if(map[x][y] == 0) {
						map[x][y] = dice[1];
					}else {
						dice[1] = map[x][y];
						map[x][y] = 0;
					}
					System.out.println(dice[6]);
				}
				break;

			}
			
			
		}
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
