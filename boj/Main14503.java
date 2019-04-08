package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14503 {
	
	// 방향 : 북 동 남 서
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int cnt;
	private static int[][] map;
	private static int N;
	private static int M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = 0;
		solve(r,c,d);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 2) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static void solve(int r, int c, int d) {
		map[r][c] = 2;
		
		boolean flag = false;
		
		for (int i = 0; i < 4; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			if(inRange(nx, ny) && map[nx][ny] == 0) flag = true;
		}
		
		if(flag) {
			int nd = d - 1;
			if(nd < 0) nd = 3;
			int nx = r + dx[nd];
			int ny = c + dy[nd];	
			
			if(inRange(nx, ny) && map[nx][ny] == 0) {
				solve(nx,ny,nd);
			}else if(inRange(nx, ny) && (map[nx][ny] == 1 || map[nx][ny] == 2)){
				solve(r,c,nd);
			}
		}else {
			int nd = (d + 2) % 4;
			int nx = r + dx[nd];
			int ny = c + dy[nd];
			if(inRange(nx, ny) && map[nx][ny] != 1) solve(nx,ny,d);
		}
		return;
	}
	
	static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}
