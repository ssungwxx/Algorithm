package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17135 {
	private static int N;
	private static int M;
	private static int D;
	private static int[][] map;
	private static int[] dx = {0,-1,0};
	private static int[] dy = {-1,0,1};
	private static int max;
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		int alive = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) alive++;
			}
		}
		max = Integer.MIN_VALUE;
		solve(0,0,alive);
		System.out.println(max);
	}

	private static void solve(int n, int y, int alive) {
		//궁수 세명 배치완료
		if(n==3) {
			int[][] clone = new int[N+1][M];
			for (int i = 0; i < clone.length; i++) {
				clone[i] = Arrays.copyOf(map[i], map[i].length);
			}
			
			int cnt = 0; // 죽인 적수
			
			while(alive > 0) {
				ArrayList<pair> target = new ArrayList<>(); // 한턴에 죽일 적들
				
				for (int c = 0; c < clone[0].length; c++) { // 궁수위치 확인
					if(clone[N][c] == 2) {
						Queue<pair> q = new LinkedList<>();
						q.add(new pair(N,c));
						boolean[][] visited = new boolean[N+1][M];
						
						while(!q.isEmpty()) {
							pair p = q.poll();
							visited[p.x][p.y] = true;
							if(clone[p.x][p.y] == 1) { // 제일먼저 발견되는적은 가장가까운적 중 좌측(탐색순서가 좌 상 우)
								target.add(new pair(p.x, p.y));
								break;
							}
							
							for (int i = 0; i < 3; i++) {
								int nx = p.x + dx[i];
								int ny = p.y + dy[i];
								if(inRange(nx, ny) && Math.abs(nx - N) + Math.abs(ny - c) <= D && !visited[nx][ny]) {
									q.add(new pair(nx,ny));
								}
							}
						}
					}
				}
				
				for (pair p : target) {
					if(clone[p.x][p.y] == 1) {
						clone[p.x][p.y] = 0;
						cnt++;
						alive--;
					}
				}
				
				//사라지는 적들 체크
				for (int i = 0; i < clone[0].length; i++) {
					if(clone[N-1][i] == 1) alive--;
				} 
				
				// 적 전진
				for (int i = N-1; i > 0; i--) {
					for (int j = 0; j < clone[0].length; j++) {
						clone[i][j] = clone[i-1][j];
					}
				}
				
				//마지막줄 초기화
				for (int i = 0; i < clone[0].length; i++) {
					clone[0][i] = 0;
				}
				
				//가능성없으면 return
				if(cnt + alive < max) return;
				
			}			
			
			max = max < cnt ? cnt : max;
			
			return;
		}
		
		if(y >= M) return;
		
		map[N][y] = 2;
		solve(n+1, y+1, alive);
		map[N][y] = 0;
		solve(n, y+1, alive);
		
		
	}
	
	static class pair{
		int x,y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
