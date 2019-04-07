package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution3143 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
         
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            String A = st.nextToken();
            String B = st.nextToken();
            int cnt = 0;
             
            for (int i = 0; i < A.length(); i++) {
                if(i + B.length() <= A.length() && A.charAt(i) == B.charAt(0) && A.substring(i, i + B.length()).equals(B)) i = i + B.length() -1 ;
                cnt++;
            }
             
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}