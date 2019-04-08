package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main1733 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[21][21];
        boolean[][][] visited = new boolean[21][21][4];
        int[] dx = {0,1,1,1};
        int[] dy = {1,1,-1,0};
        int white = 0;
        int black = 0;
        int x = -1;
        int y = -1;
         
         
        for (int i = 1; i <20; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                if(map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        if(!visited[i][j][k]) {
                            int cnt = 1;
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            while(true) {
                                 if(visited[nx][ny][k] || map[nx][ny] != map[i][j]) break;
                                 if(map[nx][ny] == map[i][j]) {
                                     visited[nx][ny][k] = true;
                                     cnt++;
                                 }
                                 nx += dx[k];
                                 ny += dy[k];
                            }
                            if(cnt == 5) {
                                if(map[i][j] == 1) {
                                    if(k == 2) {
                                        black++;
                                        x = i + 4;
                                        y = j - 4;
                                    }else {
                                        black++;
                                        x = i;
                                        y = j;                                      
                                    }
                                }else {
                                    if(k==2) {
                                        white++;
                                        x = i + 4;
                                        y = j - 4;                                      
                                    }else {
                                        white++;
                                        x = i;
                                        y = j;                                                                          
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
         
         
        if(black == 1 && white < black) {
            System.out.println(1);
            System.out.print(x + " " + y);
        }
        else if(white == 1 && white > black) {
            System.out.println(2);
            System.out.print(x + " " + y);
        }
        else System.out.println(0);
    }
}