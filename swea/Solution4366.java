package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution4366 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
             
            String str1 = br.readLine().trim();
            String str2 = br.readLine().trim();
             
            sb.append("#").append(tc).append(" ");
            Long temp2 = Long.valueOf(str2, 3);
            for (int i = 1; i < str1.length() - 1; i++) {
                StringBuilder temp = new StringBuilder();
                temp.append(str1);
                if(str1.charAt(i)=='0') {
                    temp.replace(i, i+1, "1");
                }else {
                    temp.replace(i, i+1, "0");
                }
                Long temp1 = Long.valueOf(temp.toString(), 2);
                String str = Long.toString(temp1, 3);
                temp.replace(0, temp.length(), str);
 
                if(temp1 != temp2 && temp.length() == str2.length()) {
                    int cnt = 0;
 
                    for (int j = 0; j < str2.length(); j++) {
                        if(temp.toString().charAt(j) != str2.charAt(j)) cnt++;
                    }
                    if(cnt == 1) {
                        sb.append(temp1);
                        break;
                    }
                }
                 
            }
            sb.append("\n");
             
        }
        System.out.print(sb.toString());
    }
}