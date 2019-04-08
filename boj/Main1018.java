package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1018 {
	private static char[][] check = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };
	private static int N;
	private static int M;
	private static char[][] map;
	private static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");


		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				int cnt = 0;
				int r = 0;
				for (int k = i; k < i+8; k++) {
					int c = 0;
					for (int l = j; l < j+8; l++) {
						if(map[k][l] == check[r][c++]) cnt++;
					}
					r++;
				}
				cnt = cnt > 64 - cnt ? 64-cnt : cnt;
				min = min > cnt ? cnt : min;
			}
		}
		
		


		System.out.println(min);
	}
}