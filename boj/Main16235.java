package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16235 {
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

		int[][] map = new int[N + 1][N + 1];
		int[][] feed = new int[N + 1][N + 1];
		
		Queue<tree> trees = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
				feed[i][j] = temp;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees.add(new tree(x, y, age));
		}
			
		
		for (int i = 0; i < K; i++) {
			Queue<tree> alive = new LinkedList<>();
			Queue<tree> dead = new LinkedList<>();
			Queue<tree> temp = new LinkedList<>();

			// 봄
			while(!trees.isEmpty()) {
				tree tree = trees.poll();
				if(map[tree.x][tree.y] >= tree.age) {
					map[tree.x][tree.y] -= tree.age;
					alive.add(new tree(tree.x, tree.y, tree.age + 1));
				}else {
					dead.add(tree);
				}				
			}
			

			// 여름
			while(!dead.isEmpty()) {
				tree tree = dead.poll();
				map[tree.x][tree.y] += tree.age / 2;
			}

			
			// 가을
			while(!alive.isEmpty()) {
				tree tree = alive.poll();
				if (tree.age % 5 == 0) {
					for (int k = 0; k < 8; k++) {
						int nx = tree.x + dx[k];
						int ny = tree.y + dy[k];
						if (inRange(nx, ny)) {
							trees.add(new tree(nx, ny, 1));
						}
					}
				}
				temp.add(tree);
			}
			
			while(!temp.isEmpty()) {
				tree tree = temp.poll();
				trees.add(tree);
			}

			// 겨율
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					map[j][k] += feed[j][k];
				}
			}

		}
		System.out.println(trees.size());


	}

	static class tree implements Comparable<tree>{
		int x, y, age, idx;

		public tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(tree o) {
			return this.age > o.age ? 1 : -1;
		}
		
		
	}

	static boolean inRange(int x, int y) {
		return x >= 1 && x <= N && y >= 1 && y <= N;
	}
}
