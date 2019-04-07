package swea;

import java.util.*;

public class Solution5432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int testCase = Integer.parseInt(sc.nextLine());
         
        for (int n = 1; n <= testCase; n++) {
            String input = sc.nextLine();
            int result = 0;
            Stack<Character> s = new Stack();
             
            for (int i = 0; i < input.length(); i++) {
                if(s.isEmpty() || input.charAt(i) == '(') {
                    s.push(input.charAt(i));
                }
                if(input.charAt(i) == ')') {
                    if(input.charAt(i-1) == '(') {
                        s.pop();
                        result += s.size();
                    }else {
                        s.pop();
                        result++;
                    }
                }
            }
            System.out.println("#" + n + " " + result);
        }
         
        sc.close();
    }
}