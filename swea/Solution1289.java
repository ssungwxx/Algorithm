package swea;

import java.util.*;

public class Solution1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int testCase = sc.nextInt();
         
        for(int t = 1; t <= testCase; t++) {
            String a = sc.next();
            int count = 0;
            int[] goal = new int[a.length()];
            int[] reset = new int[a.length()];
             
            for(int i =0; i < a.length(); i++) {
                goal[i] = a.charAt(i) - '0';
            }
             
            for(int i = 0; i < a.length(); i++) {
                if(reset[i] != goal[i]) {
                    for(int j =i; j < a.length();j++) {
                        reset[j] = goal[i];
                    }
                    count++;
                }
                 
            }
             
            System.out.println("#" +t+" "+count);
        }
         
        sc.close();
    }
}