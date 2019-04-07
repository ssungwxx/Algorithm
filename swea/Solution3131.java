package swea;

public class Solution3131 {
    public static void main(String[] args) {
        boolean[] ary = new boolean[1000001];
         
        for(long i = 2; i < ary.length;i++) {
            if(!ary[(int)i]) {
                System.out.print(i + " ");
                for(long j = i+i; j < ary.length;j+=i) {
                    ary[(int)j] = true;
                }
            }
        }       
    }
}