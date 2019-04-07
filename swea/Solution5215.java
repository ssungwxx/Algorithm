package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution5215 {
 
    static int[] grade;
    static int[] cal;
    static int N;
    static int L;
    static int max;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            grade = new int[N];
            cal = new int[N];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                grade[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
 
            max = Integer.MIN_VALUE;
            solve(0, 0, 0);
 
            System.out.println("#" + tc + " " + max);
        }
 
    }
 
    private static void solve(int idx, int calSum, int gradeSum) {
        if(idx > N-1) {
            if (calSum <= L && max < gradeSum) {
                max = gradeSum;
            }           
            return;
        }
        solve(idx + 1, calSum, gradeSum);
        solve(idx + 1, calSum + cal[idx], gradeSum + grade[idx]);
    }
}