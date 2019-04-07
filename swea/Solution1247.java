package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution1247 {
    static int[][] map;
    static int minLen;
    static boolean[] visited;
    static int N;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            map = new int[N + 2][2];
            minLen = Integer.MAX_VALUE;
             
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < 2; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }           
             
            visited = new boolean[N+2];
            solve(0,1,0,0);
             
            System.out.println("#" + tc + " "+minLen);
        }
    }
     
    public static  void solve(int now, int goal, int len, int count) {
        if(visited[now]) return;
        if(len > minLen) return;
        if(count == N) {
            len += Math.abs(map[now][0] - map[1][0]) + Math.abs(map[now][1] - map[1][1]);
            if(len < minLen) minLen = len;
            return;
        }
         
         
        for (int i = 2; i < map.length; i++) {
            if(now != i && !visited[i]) {
                visited[now] = true;
                int temp = Math.abs(map[now][0] - map[i][0]) + Math.abs(map[now][1] - map[i][1]);
                solve(i,1,len+temp,count+1);
                visited[now] = false;
            }
        }
         
    }
}