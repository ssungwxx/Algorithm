package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1859 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        int tc = Integer.parseInt(br.readLine().trim());
        for(int testCase = 1; testCase <= tc; testCase++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
             
             
            long sum = 0; // 범위 최악의 경우 고려해서 long형으로 지정
            int max = 0;
            for (int i = N-1; i >= 0; i--) {
                if(max < arr[i])
                    max = arr[i];
                else {
                    int num = max - arr[i];
                    sum += num;
                }
            }
             
            System.out.println("#" + testCase + " " + sum);
        }   
    }
}