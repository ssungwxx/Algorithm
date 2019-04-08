package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17136 {
	private static int[][] map;
	private static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10];
		int cnt = 0;

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cnt++;
			}
		}

		if (cnt == 0) {
			System.out.println(0);
		} else {
			int[] arr = new int[5];
			Arrays.fill(arr, 5);
			min = Integer.MAX_VALUE;
			solve(0, arr);
			if(min == Integer.MAX_VALUE) System.out.println("-1");
			else System.out.println(min);
		}
	}

	private static void solve(int x, int[] arr) {
		for (int r = x; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map[r][c] == 1) {
					for (int k = 1; k <= 5; k++) {
						if(arr[k-1] > 0) {
							boolean flag = true;
							loop: 
								for (int i = r; i < r + k; i++) {
									for (int j = c; j < c + k; j++) {
										if ((inRange(i, j) && map[i][j] != 1) || !inRange(i, j)) {
											flag = false;
											break loop;
										}
									}
								}
							if(flag) {
								
								for (int i = r; i < r + k; i++) {
									for (int j = c; j < c + k; j++) {
										map[i][j] = 0;
									}
								}
								arr[k-1]--;
								solve(r, arr);
								
								for (int i = r; i < r + k; i++) {
									for (int j = c; j < c + k; j++) {
										map[i][j] = 1;
									}
								}
								arr[k-1]++;	
							}
						
						
						}
					}

					if (map[r][c] == 1)
						return;
				}
			}
		}
		
		int cnt = 25;
		for (int i = 0; i < arr.length; i++) {
			cnt -= arr[i];
		}
		

		min = min > cnt ? cnt : min;
		return;
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < 10 && y >= 0 && y < 10;
	}
}
