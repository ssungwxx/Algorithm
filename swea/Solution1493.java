package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1493{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        int[][] map = new int[1000001][2];
        int cnt = 1;
        int nx = 1;
        int ny = 1;
        int limit = 1;
        while (cnt < map.length) {
            if (ny <= 0) {
                limit++;
                nx = 1;
                ny = limit;
            }
            map[cnt][0] = nx;
            map[cnt][1] = ny;           
            nx++;
            ny--;
            cnt++;
        }
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
 
            int X = map[p][0] + map[q][0];
            int Y = map[p][1] + map[q][1];
            int result = 0;
             
            for (int i = 0; i < map.length; i++) {
                if(map[i][0] == X && map[i][1] == Y) {
                    result = i;
                    break;
                }
            }
 
            System.out.println("#" + tc + " " + result);
        }
    }
}
