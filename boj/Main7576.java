package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {
	
	static int M,N;
	static int max;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(map);
		int max = 0;
		
		loop1:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					max = 0;
					break loop1;
				}
				if(map[i][j] > max) {
					max = map[i][j];
				}
			}
		}

		System.out.println(max-1);
	}

	public static void bfs(int[][] map) {
		Queue<where> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					q.add(new where(i,j));
				}
			}
		}

		while(!q.isEmpty()) {
			where w = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = w.x + dx[i];
				int y = w.y + dy[i];
				
				if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] == 0) {
					map[x][y] = map[w.x][w.y] + 1;
					q.add(new where(x,y));
				}
			}
		}
	}
	
	static class where{
		int x;
		int y;
		public where(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	
}
