package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution4408 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] stu = new int[2][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = (Integer.parseInt(st.nextToken()) + 1) / 2;
                int y = (Integer.parseInt(st.nextToken()) + 1) / 2;
                if(x<=y) {
                    stu[0][i] = x;
                    stu[1][i] = y;
                }else {
                    stu[0][i] = y;
                    stu[1][i] = x;
                }
                 
                 
            }
            int[] rooms = new int[201];
 
            for (int i = 0; i < N; i++) {
                int start = stu[0][i];
                int end = stu[1][i];
                for (int j = start; j <= end; j++) {
                    rooms[j]++;
                }
            }
            Arrays.sort(rooms);
             
            System.out.println("#" + tc + " " + rooms[200]);
        }
    }
}