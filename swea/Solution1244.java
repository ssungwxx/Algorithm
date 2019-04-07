package swea;

import java.util.Scanner;

public class Solution1244 {
    static int len;
    static int result;
    static boolean[][] visited;
    static int max;
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            int a = sc.nextInt();
            int n = sc.nextInt();
            result = a;
            len = String.valueOf(a).length();
             
            visited = new boolean[1000000][n+1];
            result = 0;
            solve(a,n);
 
            System.out.println("#" + tc + " " + result);
        }
 
        sc.close();
    }
 
    public static int swap(int num, int a, int b) {
        int pow1 = (int) Math.pow(10, len - a - 1);
        int pow2 = (int) Math.pow(10, len - b - 1);
        int digit1 = num / pow1 % 10;
        int digit2 = num / pow2 % 10;
        return num - digit1 * pow1 + digit2 * pow1 - digit2 * pow2 + digit1 * pow2;
    }
     
    public static void solve(int a, int n) {
        if(visited[a][n]) return;
        visited[a][n] = true;
        if(n == 0) {
            if(a > result) result = a;
            return;
        }
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                solve(swap(a,i,j), n-1);
            }
        }
         
         
    }
 
}