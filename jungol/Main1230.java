package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main1230 {
    private static int[][] map;
    private static int N;
    private static int max;
    private static boolean[][] visited;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        visited = new boolean[N][N];
 
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        max = 0;
         
        dfs(0, 0, map[0][0]/2);
        System.out.println(max);
    }
 
    private static void dfs(int x, int y, int present) {
        if(visited[x][y]) return;
        if (x == N - 1 && y == N - 1) {
            max = max < present ? present : max;
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && map[nx][ny] != 1) {
                if(map[nx][ny] == 2) dfs(nx, ny, present + 1);
                else dfs(nx, ny, present);
            }
        }
        visited[x][y] = false;
    }
 
    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}