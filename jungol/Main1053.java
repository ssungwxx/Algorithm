package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main1053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        while (true) {
            int N = Integer.parseInt(br.readLine().trim());
            if (N == -1)
                break;
            System.out.println(f(N));
        }
    }
 
    private static int f(int n) {
        if(n == 0) return 0;
        matrix temp = new matrix(1, 1, 1, 0);
        temp = pow(temp,n);
         
        return temp.b;
    }
 
    private static matrix multiply(matrix A, matrix B) {
        matrix m = new matrix(1, 1, 1, 0);
        m.a = (A.a * B.a + A.b * B.c) % 10000;
        m.b = (A.a * B.c + A.b * B.d) % 10000;
        m.c = (A.c * B.a + A.d * B.c) % 10000;
        m.d = (A.c * B.c + A.d * B.d) % 10000;
 
        return m;
    }
 
    private static matrix pow(matrix A, long n) {
        if (n > 1) {
            A = pow(A, n / 2);
            A = multiply(A, A);
             
            if(n%2 == 1) {
                matrix temp = new matrix(1, 1, 1, 0);
                A = multiply(A,temp);
            }
        }
        return A;
    }
 
    static class matrix {
        int a, b, c, d;
 
        public matrix(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
}
