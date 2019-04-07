package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1865 {
    private static double max;
    private static int N;
    private static boolean[] visited;
    private static double[][] arr;
    private static double[] memo;
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            max = Double.MIN_VALUE;
             
            N = Integer.parseInt(br.readLine());
            arr = new double[N][N];
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Double.parseDouble(st.nextToken()) / 100;
                }
            }
             
            for (int i = 0; i < N; i++) {
                visited = new boolean[N];
                memo = new double[N];
                solve(0,i,arr[0][i],"" + i);                
            }
             
             
            System.out.printf("#"+ tc + " " + "%.6f" + "\n", max);
        }
 
    }
 
    private static void solve(int n,int pnt, double sum,String test) {
        if(visited[pnt]) return;
        if(max > sum * 100) return;
        if(n == N -1) {
            max = (max < sum * 100) ? sum * 100 : max;
            return;
        }
        visited[pnt] = true;
         
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                solve(n + 1, i, sum * arr[n+1][i],test+i);
                visited[i] = false;             
            }
        }
         
    }
}