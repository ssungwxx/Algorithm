package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution4672 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine().trim();
            int cnt = 0;
            char[] arr = str.toCharArray();
            int memo[] = new int[26];
            for (int i = 0; i < arr.length; i++) {
                memo[arr[i] - 97]++;
            }
             
            for (int i = 0; i < memo.length; i++) {
                while(memo[i] > 0) {
                    cnt += memo[i];
                    memo[i]--;
                }
            }
 
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}