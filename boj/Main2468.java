package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2468 {
	
	static int n;
	static int[][] map;
	static boolean[][] water;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int max = 0;
		int cnt;
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = (max < map[i][j]) ? map[i][j] : max;
			}
		}

		for (int w = 0; w < max; w++) {
			water = new boolean[n][n];
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] > w && !water[i][j]) {
						solve(i,j,w);
						cnt++;
					}
				}
			}

			result = (cnt > result) ? cnt : result;
			
		}
		
		System.out.println(result);
	}

	public static void solve(int x, int y, int w) {
		if(water[x][y]) return;
		
		water[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < n && ny >=0 && ny < n && map[nx][ny] > w) {
				solve(nx,ny,w);
			}
		}
	}
}
