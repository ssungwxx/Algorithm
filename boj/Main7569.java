package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7569 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int[] dz = {1,-1};
	static int[][][] map;
	static boolean[][][] visited;
	static Queue<point> q;
	static int M,N,H;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		visited = new boolean[N][M][H];
		q = new LinkedList<>();
		max = 0;
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M ; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) {
						q.add(new point(i,j,k,0));
					}
				}
			}
		}
		
		bfs();
		
		boolean flag = false;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j][k] == 0) flag =true;
				}
			}
		}
		if(flag) max = -1;
		
		System.out.println(max);
	}	
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			point temp = q.poll();
			if(temp.time > max) max = temp.time;
			visited[temp.x][temp.y][temp.z] = true;
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >=0 && nx < N && ny >=0 && ny < M && !visited[nx][ny][temp.z]) {
					if(map[nx][ny][temp.z] == 0) {
						q.add(new point(nx,ny,temp.z,temp.time+1));
						map[nx][ny][temp.z] = 1;
					}
				}
			}
			
			for (int i = 0; i < 2; i++) {
				int nz = temp.z + dz[i];
				if(nz >=0 && nz < H && !visited[temp.x][temp.y][nz]) {
					if(map[temp.x][temp.y][nz] == 0) {
						q.add(new point(temp.x, temp.y, nz, temp.time+1));
						map[temp.x][temp.y][nz] = 1;
					}
				}
			}
			
		}
	}

	static class point{
		int x;
		int y;
		int z;
		int time;
		public point(int x, int y, int z,int time) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.time = time;
		}
	}
}
