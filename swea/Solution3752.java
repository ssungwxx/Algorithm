package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution3752{
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
            boolean[] arr = new boolean[10001];
            int point = 0;
            int cnt = 1;
            arr[0] = true;
 
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                for (int j = point; j >= 0; j--) {
                    if (arr[j]) {
                        if (!arr[j + temp]) {
                            arr[j + temp] = true;
                            cnt++;
                        }
                    }
                }
                if (!arr[temp]) {
                    arr[temp] = true;
                    cnt++;
                }else
                    arr[temp] = true;
                point += temp;
            }
 
            System.out.println("#" + tc + " " + cnt);
        }
    }
}