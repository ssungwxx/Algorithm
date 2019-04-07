package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution1256 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
             
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
             
            int[] sa = new int[str.length()];
            for (int i = 0; i < sa.length; i++) {
                sa[i] = i;
            }
             
            for (int i = 0; i < sa.length; i++) {
                int minIndex = i;
                for (int j = i; j < sa.length; j++) {
                    if(str.substring(sa[minIndex]).compareTo(str.substring(sa[j])) > 0) {
                        minIndex = j;
                    }
                }
                int temp = sa[minIndex];
                sa[minIndex] = sa[i];
                sa[i] = temp;
            }
             
            if(sa[n-1] > str.length()) {
                System.out.println("#"+tc+ " " + "none");               
            }else
                System.out.println("#"+tc+ " " + str.substring(sa[n-1]));
             
        }
    }
}