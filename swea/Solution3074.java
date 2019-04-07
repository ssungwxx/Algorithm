package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution3074 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
         
        for (int tc = 1; tc <= T; tc++) {
             
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            int[] t = new int[N];
            for (int i = 0; i < t.length; i++) {
                t[i] = Integer.parseInt(br.readLine().trim());
            }
            long start = 0;
            long end = 1000000000L * M;
            long min = Long.MAX_VALUE; // time 최소값
            while(start <= end) {
                long mid = (start + end) / 2;
                long cnt = 0; // 정해진 mid 시간안에 통과할 수 있는 인원수
                for (int i = 0; i < t.length; i++) {
                    cnt += mid / t[i];
                }
                if(cnt >= M && min > mid) {
                    min = mid;
                }
                if(cnt < M) start = mid + 1;
                else if(M <= cnt) end = mid -1;
            }
             
             
             
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
         
        System.out.println(sb.toString());;
    }
}