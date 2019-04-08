package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main2634 {
 
    static int near;
    static int[] bang;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
 
        bang = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            bang[i] = Integer.parseInt(st.nextToken());
        }
 
        Arrays.sort(bang);
 
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            int temp;
            if (b <= L) {
                find(0, bang.length - 1, a);
 
                temp = Math.abs(bang[near] - a) + b;
 
                if (temp <= L) {
                    cnt++;
                }
            }
 
        }
 
        System.out.println(cnt);
    }
 
    public static void find(int start, int end, int key) {
        int mid = (start + end) / 2;
        if(start > end) {
            if(start >= bang.length) {
                near = end;
                return;
            }else if(end < 0) {
                near = start;
                return;
            }
            if(Math.abs(bang[start] - key) < Math.abs(bang[end] - key)){
                near = start;
                return;
            }else {
                near = end;
                return;
            }
        }
         
        if(mid >= bang.length) {
            near = bang.length-1;
            return;
        }
        if(mid < 0) {
            near = 0;
            return;
        }
 
        if(bang[mid] == key) {
            near = mid;
            return;
        }
         
        if(bang[mid] > key) {
            find(start, mid-1, key);
        }else {
            find(mid+1,end,key);
        }
         
    }
}