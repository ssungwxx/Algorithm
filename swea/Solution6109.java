package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution6109 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int N = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            int[][] map = new int[N][N];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            switch (S) {
            case "up":
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if(map[r][c] > 0) {
                            for (int i = 1; r + i < N; i++) {
                                if(map[r + i][c] > 0) {
                                    if(map[r][c] == map[r+i][c]) {
                                        map[r][c] += map[r+i][c];
                                        map[r+i][c] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                 
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if(map[r][c] == 0) {
                            for (int i = 1; r+i < N; i++) {
                                if(map[r+i][c] > 0) {
                                    map[r][c] = map[r+i][c];
                                    map[r+i][c] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
 
            case "down":
                for (int r = N-1; r >= 0; r--) {
                    for (int c = 0; c < N; c++) {
                        if(map[r][c] > 0) {
                            for (int i = 1; r - i >= 0; i++) {
                                if(map[r - i][c] > 0) {
                                    if(map[r][c] == map[r-i][c]) {
                                        map[r][c] += map[r-i][c];
                                        map[r-i][c] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                 
                for (int r = N-1; r >= 0; r--) {
                    for (int c = 0; c < N; c++) {
                        if(map[r][c] == 0) {
                            for (int i = 1; r-i >= 0; i++) {
                                if(map[r-i][c] > 0) {
                                    map[r][c] = map[r-i][c];
                                    map[r-i][c] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
                 
            case "right":
                for (int c = N-1; c >= 0; c--) {
                    for (int r = 0; r < N; r++) {
                        if(map[r][c] > 0) {
                            for (int i = 1; c - i >= 0; i++) {
                                if(map[r][c-i] > 0) {
                                    if(map[r][c] == map[r][c-i]) {
                                        map[r][c] += map[r][c-i];
                                        map[r][c-i] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                 
                for (int c = N-1; c >= 0; c--) {
                    for (int r = 0; r < N; r++) {
                        if(map[r][c] == 0) {
                            for (int i = 1; c-i >=0 ; i++) {
                                if(map[r][c-i] > 0) {
                                    map[r][c] = map[r][c-i];
                                    map[r][c-i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
                 
            case "left":
                for (int c = 0; c < N; c++) {
                    for (int r = 0; r < N; r++) {
                        if(map[r][c] > 0) {
                            for (int i = 1; c + i < N; i++) {
                                if(map[r][c+i] > 0) {
                                    if(map[r][c] == map[r][c+i]) {
                                        map[r][c] += map[r][c+i];
                                        map[r][c+i] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                 
                for (int c = 0; c < N; c++) {
                    for (int r = 0; r < N; r++) {
                        if(map[r][c] == 0) {
                            for (int i = 1; c+i < N ; i++) {
                                if(map[r][c+i] > 0) {
                                    map[r][c] = map[r][c+i];
                                    map[r][c+i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            }
             
             
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}