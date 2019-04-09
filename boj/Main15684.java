package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15684 {
	private static int min;
	private static boolean[][] ladder;
	private static int H;
	private static int N;
	private static boolean[][] checked;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladder = new boolean[H+1][N+1];
		checked = new boolean[H+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladder[x][y] = true;
			checked[x][y] = true;
		}
		
		min = Integer.MAX_VALUE;
		
		comb(0,1,1);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	private static void comb(int n,int x, int y) {
		if(n == 4) return;
	
		check(n);
		if(min != Integer.MAX_VALUE) return;
		for (int i = x; i < ladder.length; i++) {
			for (int j = y; j < ladder[0].length-1; j++) {
				if(!ladder[i][j-1] && !ladder[i][j] && !ladder[i][j+1]) {		
					checked[i][j] = true;
					ladder[i][j] = true;
					comb(n+1,i,1);
					ladder[i][j] = false;					
				}
			}
		}
		return;
	}

	private static void check(int cnt) {
		for (int n = 1; n <= N; n++) {
			int start = n;
			for (int i = 1; i <= H; i++) {
				if(n + 1 <= N && ladder[i][n]) {
					n++;
				}else if(n -1 > 0 && ladder[i][n-1]) {
					n--;
				}
			}
			if(start != n) return;
			n = start;
		}
		min = min > cnt ? cnt : min;
	}
}
