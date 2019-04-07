package swea;

import java.util.*;

public class Solution1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int k = 0; k < 10; k++) {
            int tc = sc.nextInt();
             
            String word = sc.next();
            String n = sc.next();
            int count = 0;
             
            for(int i = 0; i < n.length() - word.length() +1;i++) {
                for(int j =0;j<word.length();j++) {
                    if(n.charAt(i+j) != word.charAt(j))
                        break;
                    if(j == word.length() -1)
                        count++;
                }
            }
             
             
            System.out.println("#" + tc + " " + count);
        }
         
        sc.close();
    }
}
