package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution1949 {
 
    static int max;
    static int N;
    static int K;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int high;
    static int[][] mountain;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            mountain = new int[N][N];
            high = 0;
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    mountain[i][j] = Integer.parseInt(st.nextToken());
                    high = (mountain[i][j] > high) ? mountain[i][j] : high;
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int[][] temp = Arrays.copyOf(mountain, mountain.length);
                    solve(i, j, K, 1, temp);
                    int[][] temp2 = Arrays.copyOf(mountain, mountain.length);
                    for (int k = 1; k <= K; k++) {                       
                        temp2[i][j] -= k;
                        solve(i,j,0,1,temp2);
                        temp2[i][j] += k;
                    }
                }
            }
 
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.print(sb.toString());
    }
 
    public static void solve(int x, int y, int k, int len, int[][] map) {
 
        if (map[x][y] == high && mountain[x][y] == high) {
            max = (max < len) ? len : max;
            return;
        }
         
 
 
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if (nx >= 0 && nx < N && ny >= 0 && ny < N ) {
                if(map[nx][ny] > map[x][y]){
                    int[][] temp = Arrays.copyOf(map, map.length);
                    solve(nx,ny,k,len+1,temp);
 
                }
                if(k > 0) {
                    for (int j = 1; j <= k; j++) {
                        if( map[x][y] < map[nx][ny] - j) {                           
                            int[][] temp = Arrays.copyOf(map, map.length);
                            temp[nx][ny] -= j;
                            solve(nx,ny,0,len+1,temp);
                            temp[nx][ny] += j;                  
                        }
                    }
                }
            }
        }
    }
}