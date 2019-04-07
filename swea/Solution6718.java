package swea;

import java.util.Scanner;

public class Solution6718 {
 
    public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        Scanner sc = new Scanner(System.in);
         
        int result;
         
        int tc = sc.nextInt();
         
        for(int i =1; i <= tc; i++) {
            int n = sc.nextInt();
             
            if(n <100) result = 0;
            else if(n <1000) result = 1;
            else if(n < 10000) result = 2;
            else if(n < 100000) result = 3;
            else if(n < 1000000) result = 4;
            else result = 5;
             
             
            System.out.println("#" + i + " " +result);
            //bw.write("#" + tc + " " +result + "\n");
        }
         
    }
}
