package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10026 {
	static int cnt1 = 0;
	static int cnt2 = 0;
	static int n;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1}; 
	static int[] dy = {-1,1,0,0}; 
			
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					solve1(i,j,map[i][j]);
					cnt1++;
				}
			}
		}
		
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 'R')
					map[i][j] = 'G';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					solve1(i,j,map[i][j]);
					cnt2++;
				}
			}
		}
		
		
		System.out.println(cnt1 + " " + cnt2);
	}

	public static void solve1(int x, int y,char val) {
		if(visited[x][y]) return;
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny <n && map[nx][ny] == val) {
				solve1(nx,ny,val);
			}
		}
		
	}
}