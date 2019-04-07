package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution3459 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            long n = Long.parseLong(br.readLine());
            System.out.print("#" + tc + " ");
             
            long A = 0;
            long B = 1;
            while(true) {
                A = (A * 2 + 1) * 2; // A값 이상이면 Alice 승
                if(n < A) {
                    System.out.println("Bob");
                    break;
                }
                 
                B = (B * 2 + 1) * 2; // B값 이상이면 Bob 승
                if(n < B) {
                    System.out.println("Alice");
                    break;
                }
            }
        }
    }
}