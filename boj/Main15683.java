package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main15683 {
	private static int min;
	private static int[][] map;
	private static int N;
	private static int M;
	private static LinkedList<pair> list;
	private static int[][] clone;
	private static int[] dx = {0,-1,0,1};
	private static int[] dy = {-1,0,1,0};
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		list = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					list.add(new pair(i, j));
				}
			}
		}
		
		if(list.size() == 0) {
			System.out.println(count(map));
		}else {
			int[] arr = new int[list.size()];
			min = Integer.MAX_VALUE;
			comb(0,arr);
			System.out.println(min);			
		}
		
	}
	
	private static void comb(int n,int[] arr) {
		if(n == arr.length) {
			clone = new int[N][M];
			for (int i = 0; i < N; i++) {
				clone[i] = Arrays.copyOf(map[i], M);
			}
			
			for (int i = 0; i < arr.length; i++) {
				cctv(list.get(i), arr[i] );
			}

			int cnt = count(clone);
			min = min > cnt ? cnt : min;
			return;
		}
		for (int i = 0; i < 4; i++) {
			arr[n] = i;
			comb(n+1, arr);
		}
		return;
	}
	
	private static void cctv(pair p, int v) {
		switch (map[p.x][p.y]) {
		case 1:
			if(v  == 0) {
				fill(p.x, p.y, v);
			}else if(v == 1) {
				fill(p.x, p.y, v);
			}else if(v == 2) {
				fill(p.x, p.y, v);		
			}else if(v == 3) {
				fill(p.x, p.y, v);				
			}
			break;
		case 2:
			if(v  == 0) {
				fill(p.x, p.y, 0);				
				fill(p.x, p.y, 2);
			}else if(v == 1) {
				fill(p.x, p.y, 1);				
				fill(p.x, p.y, 3);
			}else if(v == 2) {
				fill(p.x, p.y, 0);				
				fill(p.x, p.y, 2);
			}else if(v == 3) {
				fill(p.x, p.y, 1);				
				fill(p.x, p.y, 3);				
			}
			break;
		case 3:
			if(v  == 0) {
				fill(p.x, p.y, 0);				
				fill(p.x, p.y, 1);				
			}else if(v == 1) {
				fill(p.x, p.y, 1);				
				fill(p.x, p.y, 2);				
			}else if(v == 2) {
				fill(p.x, p.y, 2);				
				fill(p.x, p.y, 3);				
			}else if(v == 3) {
				fill(p.x, p.y, 3);				
				fill(p.x, p.y, 0);				
			}
			break;
		case 4:
			if(v  == 0) {
				fill(p.x, p.y, 0);				
				fill(p.x, p.y, 1);				
				fill(p.x, p.y, 2);				
			}else if(v == 1) {
				fill(p.x, p.y, 1);				
				fill(p.x, p.y, 2);				
				fill(p.x, p.y, 3);				
			}else if(v == 2) {
				fill(p.x, p.y, 2);				
				fill(p.x, p.y, 3);				
				fill(p.x, p.y, 0);				
			}else if(v == 3) {
				fill(p.x, p.y, 3);				
				fill(p.x, p.y, 0);				
				fill(p.x, p.y, 1);								
			}
			break;
		case 5:
			fill(p.x, p.y, 0);				
			fill(p.x, p.y, 1);								
			fill(p.x, p.y, 2);				
			fill(p.x, p.y, 3);								
			break;
		}
		return;
	}

	private static void fill(int x, int y, int v) {
		int nx = x +dx[v];
		int ny = y +dy[v];
		
		while(inRange(nx,ny) && clone[nx][ny] != 6) {
			if(clone[nx][ny] == 0) clone[nx][ny] = 7;
			nx += dx[v];
			ny += dy[v];
		}
		return;
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >=0 && y < M;
	}

	private static int count(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	

	static class pair{
		int x,y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
