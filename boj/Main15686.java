package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15686 {
	private static int M;
	private static int min;
	private static int[][] table;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		ArrayList<pair> house = new ArrayList<>();
		ArrayList<pair> chicken = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) chicken.add(new pair(i,j));
				else if(map[i][j] == 1) house.add(new pair(i, j));
			}
		}
		
		table = new int[house.size()][chicken.size()];
		for (int i = 0; i < house.size(); i++) {
			for (int j = 0; j < chicken.size(); j++) {
				table[i][j] = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
			}
		}
		
		min = Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		solve(0,0,list);
		System.out.println(min);
		
	}
	
	static void solve(int now, int cnt, ArrayList<Integer> live) {
		if(cnt == M) {
			int sum = 0;
			for (int i = 0; i < table.length; i++) {
				int m = Integer.MAX_VALUE;
				for (Integer n : live) {
					m = m > table[i][n] ? table[i][n] : m;
				}
				sum += m;
			}
			min = min > sum ? sum : min;
			return;
		}
		if(now == table[0].length) return;
		
		ArrayList<Integer> temp1 = (ArrayList<Integer>) live.clone();
		solve(now+1,cnt,temp1);
		ArrayList<Integer> temp2 = (ArrayList<Integer>) live.clone();
		temp2.add(now);
		solve(now+1,cnt+1,temp2);
		temp2.remove(temp2.size() - 1);
		
	}
	
	static class pair{
		int x,y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
