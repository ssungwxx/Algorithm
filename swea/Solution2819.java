package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Solution2819 {
 
    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Set<Integer> set = new HashSet<Integer>();
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int T = 1; T<= tc; T++){
            arr = new int[4][4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            set.clear();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    solve(i,j,0, arr[i][j]);
                }
            }
 
            System.out.println("#"+T+" "+set.size());
        }
    }
 
    public static void solve(int X, int Y, int cnt, int val){
        if(cnt == 6){
            set.add(val);
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            int nx = X + dx[i];
            int ny = Y + dy[i];
            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
                continue;
            solve(nx, ny,cnt+1,val*10 + arr[nx][ny]);
        }
         
    }
}