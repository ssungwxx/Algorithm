package swea;

import java.nio.charset.StandardCharsets;
import java.util.*;
 
public class Solution1928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int testCase = Integer.parseInt(sc.nextLine());
         
        for(int tc = 1; tc <= testCase; tc++){
            String input = sc.nextLine();
             
            byte[] decoded = Base64.getDecoder().decode(input);
             
            System.out.println("#" + tc + " " + new String(decoded,StandardCharsets.UTF_8));
        }
         
        sc.close();
    }
}