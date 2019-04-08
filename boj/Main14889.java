package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main14889 {
	private static int N;
	private static int[][] map;
	private static int min;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer> start = new ArrayList<>();
		ArrayList<Integer> link = new ArrayList<>();
		min = Integer.MAX_VALUE;
		solve(0,start, link);
		System.out.println(min);
		
	}

	private static void solve(int n, ArrayList<Integer> start, ArrayList<Integer> link) {
		if(start.size() == N/2 && start.size() == link.size()) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < start.size() - 1; i++) {
				for (int j = i+1; j < start.size(); j++) {
					sum1 += map[start.get(i)][start.get(j)];
					sum1 += map[start.get(j)][start.get(i)];
				}
			}
			for (int i = 0; i < link.size() - 1; i++) {
				for (int j = i+1; j < link.size(); j++) {
					sum2 += map[link.get(i)][link.get(j)];
					sum2 += map[link.get(j)][link.get(i)];
				}
			}

			min = Math.abs(sum1-sum2) < min ? Math.abs(sum1-sum2) : min;
			return;
		}
		
		if(start.size() <= N/2) {
			ArrayList<Integer> temp1 = new ArrayList<>();
			ArrayList<Integer> temp2 = new ArrayList<>();
			temp1 = (ArrayList<Integer>) start.clone();
			temp2 = (ArrayList<Integer>) link.clone();
			temp1.add(n);
			solve(n+1, temp1, temp2);
		}
		if(link.size() <= N/2) {
			ArrayList<Integer> temp1 = new ArrayList<>();
			ArrayList<Integer> temp2 = new ArrayList<>();
			temp1 = (ArrayList<Integer>) start.clone();
			temp2 = (ArrayList<Integer>) link.clone();
			temp2.add(n);
			solve(n+1, temp1, temp2);
		}
		
	}
}
