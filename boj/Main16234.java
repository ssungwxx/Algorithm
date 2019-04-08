package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main16234 {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	private static int N;
	private static int L;
	private static int R;
	private static boolean flag;
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<pair> list;
	private static int sum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = -1;
		
		flag = true;
		while(flag) {

			flag = false;
			solve();
			cnt++;
		}
		
		System.out.print(cnt);
	}
	
	private static void solve() {
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					list = new ArrayList<>();
					list.add(new pair(i, j));
					sum = 0;
					union(i,j);
					if(list.size() > 1) {
						int temp = sum / list.size();
						flag = true;
						for (pair item : list) {
							map[item.x][item.y] = temp;
						}
					}
				}
			}
		}
	}
	
	private static void union(int x, int y) {
		visited[x][y] = true;
		sum += map[x][y];
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(inRange(nx, ny) && !visited[nx][ny] && Math.abs(map[nx][ny] - map[x][y]) >= L && Math.abs(map[nx][ny] - map[x][y]) <= R) {
				list.add(new pair(nx, ny));
				union(nx,ny);
			}
		}
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && y >= 00 && x < N && y < N;
	}
	
	static class pair{
		int x,y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
