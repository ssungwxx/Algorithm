package swea;

import java.util.*;

public class Solution1223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int tc = 1; tc <=10; tc++) {
            int tl = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            char[] stack = new char[tl];
            String str2 = "";
            int top = -1;
             
            for(int i = 0; i < tl; i++) {
                char c = str.charAt(i);
                 
                switch (c) {
                case '*':
                    while (top > -1 && stack[top] == '*') {
                        str2 += stack[top] + " ";
                        top--;
                    }
                    stack[++top] = c;
                    break;
                case '+':
                    while (top > -1 && (stack[top] == '+' || stack[top] == '*')) {
                        str2 += stack[top] + " ";
                        top--;
                    }
                    stack[++top] = c;
                    break;
                default:
                    str2 += c + " ";
                    break;
                }
            }
             
            while(top > -1) {
                str2 += stack[top--] + " ";
            }
             
            String[]input = str2.split(" ");
            int[] stack2 = new int[input.length];
            int top2 = -1;
            for(int i = 0; i < input.length; i++) {
                char temp = input[i].charAt(0);
                int num1, num2;
                switch (temp) {
                case '*':
                    num2 = stack2[top2--];
                    num1 = stack2[top2--];
                    stack2[++top2] = num1 * num2;
                    break;
                case '+':
                    num2 = stack2[top2--];
                    num1 = stack2[top2--];
                    stack2[++top2] = num1 + num2;
                    break;
                default:
                    stack2[++top2] = (temp - '0');
                    break;
                }
            }
             
         
            System.out.println("#"+tc+" "+stack2[0]);
        }
         
        sc.close();
    }
}