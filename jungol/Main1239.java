package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main1239 {
     
    static String[][] arr = {
            {"000000", "000001","000010","000100","001000","010000","100000"}, // A
            {"001111","001110","001101","001011","000111","011111","101111"}, // B
            {"010011","010010","010001","010111","011011","000011","110011"}, // C
            {"011100","011101","011110","011000","010100","001100","111100"}, // D
            {"100110","100111","100100","100010","101110","110110","000110"}, // E
            {"101001","101000","101011","101101","100001","111001","001001"}, // F
            {"110101","110100","110111","110001","111101","100101","010101"}, // G
            {"111010","111011","111000","111110","110010","101010","011010"} // H
    };
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine().trim());
        String[] str = new String[N]; 
        String temp = br.readLine().trim();
        StringBuilder sb = new StringBuilder();
         
        for (int i = 0; i < N; i++) {
            str[i] = temp.substring(i * 6, i * 6 + 6);
            boolean check = true;
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 7; k++) {
                    if(str[i].equals(arr[j][k])) {
                        switch (j) {
                        case 0:
                            sb.append("A");
                            break;
                        case 1:
                            sb.append("B");
                            break;
                        case 2:
                            sb.append("C");
                            break;
                        case 3:
                            sb.append("D");
                            break;
                        case 4:
                            sb.append("E");
                            break;
                        case 5:
                            sb.append("F");
                            break;
                        case 6:
                            sb.append("G");
                            break;
                        case 7:
                            sb.append("H");
                            break;
                        }
                        check = false;
                    }
                }
            }
            if(check) sb.append("*");
        }
         
        boolean flag = true;
        for (int i = 0; i < sb.toString().length(); i++) {
            if(sb.toString().charAt(i) == '*') {
                flag = false;
                System.out.println(i + 1);
                break;
            }
        }
         
        if(flag) System.out.println(sb.toString());
         
         
    }
}