package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution4050 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
         
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int price = 0;
 
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                price += arr[i];
            }
             
            Arrays.sort(arr);
             
            for (int i = arr.length - 3 ; i >= 0; i-=3) {
                price -= arr[i];
            }
             
             
            sb.append("#").append(tc).append(" ").append(price).append("\n");
        }
        System.out.print(sb.toString());
    }
}