package swea;

import java.util.*;

public class Solution1210 {
 
    static int[][] map = new int[100][100];
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int n = 0; n < 10; n++) {
            int tc = sc.nextInt();
 
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
 
            int Y = 0;
            for (int i = 0; i < 100; i++) {
                if (map[99][i] == 2)
                    Y = i;
            }
             
            for (int i = 99; i >= 0; i--) {
                if (Y + 1 <= 99 && map[i][Y + 1] == 1) {
                    while (true) {
                        Y++;
                        if (Y + 1 > 99 || map[i][Y + 1] != 1)
                            break;
 
                    }
                } else if (Y - 1 >= 0 && map[i][Y - 1] == 1) {
                    while (true) {
                        Y--;
                        if (Y - 1 < 0 || map[i][Y - 1] != 1)
                            break;
                    }
                }
            }
 
            System.out.println("#" + tc + " " + Y);
        }
 
        sc.close();
    }
}