package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15685 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		boolean[][] map = new boolean[101][101];
		int[] dx = {0,-1,0,1};
		int[] dy = {1,0,-1,0};
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int x = Integer.parseInt(st.nextToken()); // x��ǥ
			int y = Integer.parseInt(st.nextToken()); // y��ǥ
			int d = Integer.parseInt(st.nextToken()); // ���۹��� 0 �� 1 �� 2 �� 3 ��
			int g = Integer.parseInt(st.nextToken()); // �巡�＼��
			
			ArrayList<Integer> list = new ArrayList<>();
			list.add(d);
			for (int i = 0; i < g; i++) {
				for (int j = list.size()-1; j >= 0; j--) {
					int temp = list.get(j) + 1;
					if(temp > 3) temp = 0;
					list.add(temp);
				}
			}
			map[y][x] = true;
			for (Integer i : list) {
				y +=dx[i];
				x += dy[i];
				map[y][x] = true;
			}

		}
		
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]) {
					if(i+1 < 101 && j+1 < 101 && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
