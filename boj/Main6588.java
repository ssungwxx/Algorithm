package boj;

import java.io.*;

public class Main6588 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] prime = new int[1000000];
        boolean[] check = new boolean[1000001];
        int count = 0;

        for (int i = 2; i <= 1000000; i++) {
            if (check[i] == false) {
                prime[count++] = i;
                for (int j = i * 2; j <= 1000000; j += i) {
                    check[j] = true;
                }
            }
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;

            for(int i = 3; i <= n; i++){
                if(!check[i] && !check[n - i]){
                    bw.write(String.format("%d = %d + %d\n", n, i, n-i));
                    break;
                }
            }
        }


        bw.close();
    }
}