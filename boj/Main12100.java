package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main12100{
	private static int N;
	private static int result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		for (int i = 0; i < 4; i++) {
			int[][] temp = new int[N][N];
			for (int j = 0; j < N; j++) {
				temp[j] = Arrays.copyOf(map[j], N);
			}
			solve(0,i,temp);
		}
		System.out.println(result);
	}

	private static void solve(int n, int v, int[][] map) {
		
		if(n == 5) {
			int max = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					max = max < map[i][j] ? map[i][j] : max;
				}
			}
			
			result = result < max ? max : result;
			return;
		}
		
		switch (v) {
		case 0:
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] > 0) {
						for (int i = 1; r + i < N; i++) {
							if(map[r + i][c] > 0) {
								if(map[r][c] == map[r+i][c]) {
									map[r][c] += map[r+i][c];
									map[r+i][c] = 0;
								}
								break;
							}
						}
					}
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == 0) {
						for (int i = 1; r+i < N; i++) {
							if(map[r+i][c] > 0) {
								map[r][c] = map[r+i][c];
								map[r+i][c] = 0;
								break;
							}
						}
					}
				}
			}
			break;

		case 1:
			for (int r = N-1; r >= 0; r--) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] > 0) {
						for (int i = 1; r - i >= 0; i++) {
							if(map[r - i][c] > 0) {
								if(map[r][c] == map[r-i][c]) {
									map[r][c] += map[r-i][c];
									map[r-i][c] = 0;
								}
								break;
							}
						}
					}
				}
			}
			
			for (int r = N-1; r >= 0; r--) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == 0) {
						for (int i = 1; r-i >= 0; i++) {
							if(map[r-i][c] > 0) {
								map[r][c] = map[r-i][c];
								map[r-i][c] = 0;
								break;
							}
						}
					}
				}
			}
			break;
			
		case 2:
			for (int c = N-1; c >= 0; c--) {
				for (int r = 0; r < N; r++) {
					if(map[r][c] > 0) {
						for (int i = 1; c - i >= 0; i++) {
							if(map[r][c-i] > 0) {
								if(map[r][c] == map[r][c-i]) {
									map[r][c] += map[r][c-i];
									map[r][c-i] = 0;
								}
								break;
							}
						}
					}
				}
			}
			
			for (int c = N-1; c >= 0; c--) {
				for (int r = 0; r < N; r++) {
					if(map[r][c] == 0) {
						for (int i = 1; c-i >=0 ; i++) {
							if(map[r][c-i] > 0) {
								map[r][c] = map[r][c-i];
								map[r][c-i] = 0;
								break;
							}
						}
					}
				}
			}
			break;
			
		case 3:
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					if(map[r][c] > 0) {
						for (int i = 1; c + i < N; i++) {
							if(map[r][c+i] > 0) {
								if(map[r][c] == map[r][c+i]) {
									map[r][c] += map[r][c+i];
									map[r][c+i] = 0;
								}
								break;
							}
						}
					}
				}
			}
			
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					if(map[r][c] == 0) {
						for (int i = 1; c+i < N ; i++) {
							if(map[r][c+i] > 0) {
								map[r][c] = map[r][c+i];
								map[r][c+i] = 0;
								break;
							}
						}
					}
				}
			}
			break;
		}
		
		for (int i = 0; i < 4; i++) {
			int[][] temp = new int[N][N];
			for (int j = 0; j < N; j++) {
				temp[j] = Arrays.copyOf(map[j], N);
			}
			solve(n+1,i,temp);
		}
		
	}
}
