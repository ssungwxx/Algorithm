package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5656 {
	private static int N;
	private static int W;
	private static int H;
	private static int min;
	private static int[][] map;
	private static int[][] clone;
	private static int[] arr;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int[W][H];

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < H; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			arr = new int[N];
			min = Integer.MAX_VALUE;
			comb(0);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void comb(int n) {
		if (n == N) {
			clone = new int[W][H];
			for (int i = 0; i < W; i++) {
				clone[i] = Arrays.copyOf(map[i], H);
			}

			for (int i = 0; i < arr.length; i++) {
				shoot(arr[i]);
			}

			int cnt = 0;
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {
					if (clone[i][j] != 0)
						cnt++;
				}
			}
			if (cnt < min) {
				min = cnt;
			}
			return;
		}

		for (int i = 0; i < H; i++) {
			arr[n] = i;
			comb(n+1);
		}
	}

	private static void shoot(int n) {
		for (int i = 0; i < W; i++) {
			if (clone[i][n] > 0) {
				bomb(i, n);
				fall();
				return;
			}
		}
		return;
	}

	private static void fall() {
		for (int i = 0; i < H; i++) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			for (int j = W - 1; j >= 0; j--) {
				if (clone[j][i] > 0) {
					list.add(clone[j][i]);
					clone[j][i] = 0;
				}
			}
			for (int j = 0; j < list.size(); j++) {
				clone[W - j - 1][i] = list.get(j);
			}
		}
		return;
	}

	private static void bomb(int x, int y) {
		Queue<block> q = new LinkedList<>();
		q.add(new block(x, y));
		
		while(!q.isEmpty()){
			block b = q.poll();
			int temp = clone[b.x][b.y];
			clone[b.x][b.y] = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < temp; j++) {
					int nx = b.x + (dx[i] * j);
					int ny = b.y + (dy[i] * j);
					if(inRange(nx, ny) && clone[nx][ny] > 0)
						q.add(new block(nx,ny));
				}
			}
		}
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < W && y >= 0 && y < H;
	}
	
	static class block{
		int x,y;
		public block(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
