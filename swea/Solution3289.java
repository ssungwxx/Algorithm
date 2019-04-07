package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution3289{
    private static int[] arr;
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            arr = new int[N+1];
            for (int i = 1; i <= N; i++) {
                arr[i] = i;
            }
            sb.append("#").append(tc).append(" ");
             
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                String sep = st.nextToken();
                if(sep.equals("0")) {
                    int num1 = Integer.parseInt(st.nextToken());
                    int num2 = Integer.parseInt(st.nextToken());
                    union(num1, num2);
                     
                }else { // sep 1
                    int num1 = Integer.parseInt(st.nextToken());
                    int num2 = Integer.parseInt(st.nextToken());
                    num1 = find(num1);
                    num2 = find(num2);
                    if(num1 == num2) sb.append("1");
                    else sb.append("0");
                     
                }
            }
 
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
     
    static int find(int x) {
        if(x == arr[x]) return x;
        else {
            int y = find(arr[x]);
            arr[x] = y;
            return y;
        }
    }
     
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x!=y) arr[y] = x;
    }
}