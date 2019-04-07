package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1861{
 
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int point;
    static int maxMove;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];
 
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            point = 0;
            maxMove = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    visited = new boolean[N + 1][N + 1];
                    solve(i, j, map[i][j], 1);
                }
            }
 
            System.out.println("#" + tc + " "+ point + " " + maxMove);
        }
    }
 
    public static void solve(int x, int y, int start, int move) {
        if (visited[x][y])
            return;
        if(move > maxMove) {
            maxMove = move;
            point = start;
        }
        if(move == maxMove && point > start) {
            point = start;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 1 && nx <=N && ny >=1 && ny <= N && map[x][y] + 1 == map[nx][ny]) {
                solve(nx,ny,start,move+1);
            }
        }
    }
 
}