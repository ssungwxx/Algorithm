package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution2117 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int max;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };
    private static int maxfee;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            maxfee = 0;
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) maxfee += M;
                }
            }
            
            max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    solve(i,j);
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.print(sb.toString());
 
    }
 
    private static void solve(int r, int c) {
        Queue<house> q;
        int k = 1;
        while (k > 0) {
            q = new LinkedList<>();
            q.add(new house(r, c, 1));
            boolean[][] visited = new boolean[N][N];
            int oper = k * k + (k - 1) * (k - 1);
            int fee = 0;
            int cnt = 0;
            // 방범시스템 내의 거리 알기
            while (!q.isEmpty()) {
                house h = q.poll();
                visited[h.x][h.y] = true;
                if (map[h.x][h.y] == 1) {
                    fee += M;
                    cnt++;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = h.x + dx[i];
                    int ny = h.y + dy[i];
 
                    if (h.l < k && inRange(nx, ny) && !visited[nx][ny]) {
                        q.add(new house(nx, ny, h.l + 1));
                        visited[nx][ny] = true;
                    }
                }
 
            }
            fee = fee - oper;
 
            if (fee >= 0)
                max = max < cnt ? cnt : max;
            if(oper > maxfee)
                break;
            k++;
        }
    }
 
    static class house {
        int x, y, l;
 
        public house(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }
 
    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}