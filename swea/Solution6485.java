package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution6485 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int[] map = new int[5001];
            int N = Integer.parseInt(br.readLine());
            int[][] bus = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                bus[i][0] = Integer.parseInt(st.nextToken());
                bus[i][1] = Integer.parseInt(st.nextToken());
            }
             
            int P = Integer.parseInt(br.readLine());
            int[] idx = new int[P];
            for (int i = 0; i < P; i++) {
                idx[i] = Integer.parseInt(br.readLine());
            }
             
            for (int i = 0; i < bus.length; i++) {
                int start = bus[i][0];
                int end = bus[i][1];
                for (int j = start; j <= end; j++) {
                    map[j]++;
                }
            }
 
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc);
            for (int i = 0; i < idx.length; i++) {
                sb.append(" " + map[idx[i]]);
            }
             
            System.out.println(sb.toString());
        }
    }
}