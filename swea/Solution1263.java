package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1263 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int M = Integer.MAX_VALUE;
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if(i==j)
                        arr[i][j] = 0;                      
                    else if(temp != 0)
                        arr[i][j] = temp;
                    else
                        arr[i][j] = M;
                }
            }
             
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if(k == i)
                        continue;
                    if(arr[i][k] == M)
                        continue;
                    for (int j = 0; j < n; j++) {
                        if(k == j || j == i)
                            continue;
                        if(arr[k][j] == M)
                            continue;
                        if(arr[i][j] > arr[i][k] + arr[k][j])
                            arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
            int min = M;
             
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < arr.length; j++) {
                    sum += arr[i][j];
                }
                min = (min > sum) ? sum : min;
            }
             
            System.out.println("#" + tc + " "+ min);
        }
         
         
    }
}