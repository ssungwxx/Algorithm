package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
 
public class Solution1228 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        for(int tc = 1 ; tc <= 10; tc++) {
             
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            int cn = Integer.parseInt(br.readLine());
            String[] command = br.readLine().split(" ");
             
            for(int i = 0; i < command.length; i++) {
                if(command[i].equals("I")) {
                    int x = Integer.parseInt(command[i+1]);
                    int y = Integer.parseInt(command[i+2]);
                     
                    for(int j = y-1; j >= 0; j--) {
                        list.add(x, command[i+j+3]);
                    }
                }
            }
             
            String result = "";
            for(int i = 0; i < 10; i++) {
                result += list.get(i) + " ";
            }
             
             
            System.out.println("#" + tc + " " + result);
        }
         
         
        br.close();
        bw.close();
    }
}