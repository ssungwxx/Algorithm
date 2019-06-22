package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution7699 {
    static int[][] map;
    static int R,C,max;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());           
            C = Integer.parseInt(st.nextToken());           
            map = new int[R][C];
             
            for (int i = 0; i < R; i++) {
                String str = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j)-'A';
                }
            }
             
            max = 0;
            solve(1 << map[0][0],0,0,1);
             
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
     
    public static void solve(int visit, int r, int c,int cnt) {
        if(max == 26) return;
        max = (max < cnt) ? cnt : max;
         
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
             
            if(inRange(nx, ny) && (visit & (1 << map[nx][ny])) == 0) {
                solve(visit | (1 << map[nx][ny]), nx, ny, cnt + 1);
            }
        }
    }
     
    public static boolean inRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}