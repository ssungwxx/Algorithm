package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1233 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[10000];
            boolean[] check = new boolean[n + 1];
            boolean flag = false;
 
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str, " ");
 
                while (st.hasMoreTokens()) {
                    int start = Integer.parseInt(st.nextToken());
                    char numCheck = st.nextToken().charAt(0);
                    if (!(numCheck >= 48 && numCheck <= 57)) {
                        check[start] = true;
                    }
                    if (!st.hasMoreTokens()) {
                        if(check[start])
                            flag = true;
                        break;
                    }
                    int node1 = Integer.parseInt(st.nextToken());
                    if (!st.hasMoreTokens())
                        break;
                    int node2 = Integer.parseInt(st.nextToken());
 
                    for (int j = 1; j < arr.length; j++) {
                        if (start == arr[j]) {
                            if (!(node1 == -1)) {
                                arr[j * 2] = node1;
                                 
                            }
                            if (!(node2 == -1)) {
                                arr[j * 2 + 1] = node2;
                                 
                            }
                            break;
                        }
                    }
                     
                     
                     
                }
 
            }
            if(flag)
                System.out.println("#" + tc + " " + 0);
            else
                System.out.println("#" + tc + " " + 1);
                 
                 
        }
    }
}