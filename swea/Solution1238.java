package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution1238{
 
    private static Queue<pair> q;
    private static int N;
    private static int start;
    private static int[][] arr;
    private static boolean[] visited;
    private static int last;
    private static int max;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
 
            arr = new int[N / 2][2];
            q = new LinkedList<>();
            visited = new boolean[101];
 
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
 
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] == start) {
                    q.add(new pair(arr[i][0], arr[i][1], 1));
                }
            }
            visited[start] = true;
            solve();
 
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.print(sb.toString());
    }
 
    public static void solve() {
        last = 0;
        max = 0;
        while (!q.isEmpty()) {
            pair temp = q.poll();
            for (int i = 0; i < arr.length; i++) {
                if (temp.e == arr[i][0] && !visited[arr[i][1]]) {
                    q.add(new pair(arr[i][0], arr[i][1], temp.check + 1));
                    visited[arr[i][1]] = true;
                }
            }
            if (last < temp.check) {
                last = temp.check;
                max = temp.e;
            }
            else if (last == temp.check) {
                max = (temp.e > max) ? temp.e : max;
            }
        }
    }
 
    public static class pair {
        int s;
        int e;
        int check;
 
        public pair(int s, int e, int check) {
            this.s = s;
            this.e = e;
            this.check = check;
        }
 
    }
}