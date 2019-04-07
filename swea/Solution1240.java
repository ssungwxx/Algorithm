package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution1240 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            int[][] arr = new int[x][y];
            int check = -1;
             
            for (int i = 0; i < x; i++) {
                String temp = br.readLine();
                for (int j = 0; j < y; j++) {
                    arr[i][j]=temp.charAt(j) - '0';
                    if(arr[i][j] == 1) {
                        check = i;
                    }
                }
            }
             
            StringBuilder sb = new StringBuilder();
             
            for (int i = y-1; i >= 0; i--) {
                if(arr[check][i] == 1) {
                    for (int j = 0; j < 56; j++) {
                        sb.append(arr[check][i-55+j]);
                    }
                    break;
                }
            }
             
            String[] cd = new String[8];
 
            for (int i = 0; i < 8; i++) {
                cd[i] = sb.toString().substring(i*7,i*7+7);
            }
             
             
            int fin = 0;
            int temp =0;
            for (int i = 0; i < cd.length-1; i++) {
                 
                if(i%2 == 0) {
                    temp += solve(cd[i]);
                }else {
                    fin += solve(cd[i]);
                }
            }
             
            fin += temp * 3 + solve(cd[7]);
            int result = 0;
            if(fin % 10 ==0) {
                for (int i = 0; i < cd.length; i++) {
                    result+=solve(cd[i]);
                }
            }
         
            System.out.println("#"+tc+" "+result);
        }
         
    }
     
     
    public static int solve(String str) {
        switch (str) {
        case "0001101" :    
            return 0;
        case "0011001" :    
            return 1;
        case "0010011" :    
            return 2;
        case "0111101" :    
            return 3;
        case "0100011" :    
            return 4;
        case "0110001" :    
            return 5;
        case "0101111" :    
            return 6;
        case "0111011" :    
            return 7;
        case "0110111" :    
            return 8;
        case "0001011" :    
            return 9;
        }
         
        return -1;
 
    }
}