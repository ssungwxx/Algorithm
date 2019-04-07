package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution4301 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int[] dx = {0,2};
        int[] dy = {2,0};
         
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = N * M;
            boolean[][] map = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!map[i][j]) {
                        for (int k = 0; k < 2; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx >=0 && nx < N && ny >= 0 && ny < M && !map[nx][ny]) {
                                map[nx][ny] = true;
                                cnt--;
                            }
                        }
                    }
                }
            }
 
             
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}