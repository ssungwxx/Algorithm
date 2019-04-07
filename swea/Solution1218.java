package swea;

import java.util.*;

public class Solution1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
            int result = -1;
 
            int n = Integer.parseInt(sc.nextLine());
            int[] check = new int[4];
 
            String input = sc.nextLine();
 
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '(') {
                    check[0]++;
                }else if(input.charAt(i) == '[') {
                    check[1]++;
                }else if(input.charAt(i) == '{') {
                    check[2]++;
                }else if(input.charAt(i) == '<') {
                    check[3]++;
                }else if(input.charAt(i) == ')') {
                    check[0]--;
                }else if(input.charAt(i) == ']') {
                    check[1]--;
                }else if(input.charAt(i) == '}') {
                    check[2]--;
                }else if(input.charAt(i) == '>') {
                    check[3]--;
                }
            }
             
            for(int i = 0 ; i < 4; i++) {
                if(check[i] != 0) {
                    result = 0;
                    break;
                }else
                    result = 1; 
            }
             
            System.out.println("#" + tc + " " + result);
        }
 
        sc.close();
    }
}