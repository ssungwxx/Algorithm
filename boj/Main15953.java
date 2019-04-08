package boj;

import java.io.*;

public class Main15953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String testCaseTemp = br.readLine();

        int testCase = Integer.parseInt(testCaseTemp);
        if (0 < testCase || testCase > 1000) {
            while (testCase > 0) {
                int prize = 0;

                String temp = br.readLine();

                String[] result = temp.split(" ");

                int result1 = Integer.parseInt(result[0]);
                int result2 = Integer.parseInt(result[1]);

                if(result1>0 && result1<101) {
                    if (result1 < 2) prize += 500;
                    else if (result1 < 4) prize += 300;
                    else if (result1 < 7) prize += 200;
                    else if (result1 < 11) prize += 50;
                    else if (result1 < 16) prize += 30;
                    else if (result1 < 22) prize += 10;
                }else result1 = 0;

                if(result2 > 0 && result2 < 65){
                    if (result2 < 2) prize += 512;
                    else if (result2 < 4) prize += 256;
                    else if (result2 < 8) prize += 128;
                    else if (result2 < 16) prize += 64;
                    else if (result2 < 32) prize += 32;
                }else result2 = 0;

                prize *= 10000;

                System.out.println(prize);

                testCase--;
            }
        }
    }
}
