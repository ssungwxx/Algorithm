package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2606 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int M = Integer.MAX_VALUE;
		int[][] map = new int[n+1][n+1];
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				if( i != j)
					map[i][j] = M;
			}
		}
		
		int in = Integer.parseInt(br.readLine());
		for (int i = 0; i < in; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x == 1 || y == 1) {
				map[y][x] = 1000;
				map[x][y] = 1000;				
			}else {
				map[y][x] = 1;
				map[x][y] = 1;
			}
		}
		
		for (int k = 1; k < n; k++) {
			for (int i = 1; i < n+1; i++) {
				if(i == k)
					continue;
				if(map[i][k] == M)
					continue;
				for (int j = 1; j < n+1; j++) {
					if(j == k || i ==j)
						continue;
					if(map[k][j] == M)
						continue;
					if(map[i][k] + map[k][j] < map[i][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		int sum = 0;
		for (int i = 1; i < map.length; i++) {
			boolean check = false;
			for (int j = 1; j < map.length; j++) {
				if(map[i][j] != M && map[i][j] > 999) {
					check = true;
					continue;
				}
			}
			if(check) sum++;
		}

		System.out.println(sum-1);
	}
}
