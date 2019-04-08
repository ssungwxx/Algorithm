package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main2667 {
	
	static int N;
	static int max;
	static int[][] map;
	static int[] dx = {1,-1,0,0};	
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		ArrayList<Integer> li = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					max = 0;
					cnt++;
					solve(i,j);
					li.add(max);
				}
			}
		}
		
		Collections.sort(li);
		System.out.println(cnt);
		for (Integer item : li) {
			System.out.println(item);
		}
		
	}

	public static void solve(int x, int y) {
		if(map[x][y] != 1) return;
		map[x][y] = 0;
		max++;
		for (int i = 0; i < 4; i++) {
			if(x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N) {
				solve(x+dx[i], y + dy[i]);
			}
		}
	}
}

