package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main2097 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int MAX = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int s = 0;
        boolean[] used = new boolean[N];
         
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0)  map[i][j] = MAX;
            }
        }
         
        int[] D = map[s].clone();
        int[] trace = new int[N];
        StringBuilder sb = new StringBuilder();
         
         
        for (int i = 0; i < trace.length; i++) {
            if(D[i] != MAX) trace[i] = 0;
            else trace[i] = -1;
        }
         
        for (int i = 0; i < N; i++) {
            int minIndex = -1;
            int min = MAX;
            for (int j = 0; j < N; j++) {
                if(!used[j] && min > D[j]) {
                    minIndex = j;
                    min = D[j];
                }
            }
            used[minIndex] = true;
             
            for (int j = 0; j < N; j++) {
                if(!used[j] && map[minIndex][j] != MAX && D[j] > D[minIndex] + map[minIndex][j]) {
                    D[j] = D[minIndex] + map[minIndex][j];
                    trace[j] = minIndex;
                }
            }
        }
         
        System.out.println(D[M-1]);
        sb.append(1);
        for (int i = M-1; i != 0; i=trace[i]) {
            sb.insert(1," " + (i+1));
        }
         
        System.out.println(sb.toString());
    }
}