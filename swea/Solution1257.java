package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution1257 {
    public static void main(String[] args) throws Exception {
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
                    if (str.substring(sa[minIndex]).compareTo(str.substring(sa[j])) > 0) {
                        minIndex = j;
                    }
                }
                int temp = sa[minIndex];
                sa[minIndex] = sa[i];
                sa[i] = temp;
            }
 
            int[] LCP = new int[str.length()];
 
            for (int i = 1; i < LCP.length; i++) {
                String s1 = str.substring(sa[i - 1]);
                String s2 = str.substring(sa[i]);
 
                while (s1.length() > LCP[i] && s2.length() > LCP[i] && s1.charAt(LCP[i]) == s2.charAt(LCP[i])) {
                    LCP[i]++;
                }
            }
 
            int index = n;
            boolean flag = true;
             
            for (int i = 0; i < sa.length; i++) {
                String temp = str.substring(sa[i]);
                if (index - (temp.length() - LCP[i]) > 0) {
                    index = index - (temp.length() - LCP[i]);
                } else {
                    System.out.println("#" + tc + " " + temp.substring(0, LCP[i] + index));
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("#" + tc + " none");
        }
    }
}