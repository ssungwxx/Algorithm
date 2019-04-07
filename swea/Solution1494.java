package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1494 {
 
    static int N;
    static int[][] map;
    static boolean[] visited;
    static long min;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
 
            map = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }
 
            visited = new boolean[N];
            min = Long.MAX_VALUE;
            solve(0, 0);
 
            System.out.println("#" + tc + " " + min);
        }
    }
 
    public static void solve(int now, int cnt) {
        if (cnt == N / 2) {
            long x = 0;
            long y = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    x += map[i][0];
                    y += map[i][1];
                } else {
                    x -= map[i][0];
                    y -= map[i][1];
                }
            }
 
            long V = x * x + y * y;
            min = (V < min) ? V : min;
            return;
        }
        for (int i = now; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(i, cnt + 1);
                visited[i] = false;
            }
        }
    }
}