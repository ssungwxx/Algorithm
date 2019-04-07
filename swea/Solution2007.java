package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution2007 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
         
        for (int tc = 1; tc <= T; tc++) {
            int count = 0;
             
            String str = br.readLine().trim();
            int len = str.length();
             
            StringBuilder sb = new StringBuilder();
             
            for (int i = 0; i < len; i++) {
                sb.append(str.charAt(i));
                String temp = sb.toString();
                while(temp.length() < 30) {
                    temp += sb.toString();
                }
 
                if(temp.substring(0, 30).equals(str)) {
                    count = sb.length();
                    break;
                }
            }
             
            System.out.println("#"+tc+" "+count);
        }
         
    }
}