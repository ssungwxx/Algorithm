package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1873 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            int nx = 0;
            int ny = 0;
 
            for (int i = 0; i < H; i++) {
                String temp = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = temp.charAt(j);
                    if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>') {
                        nx = i;
                        ny = j;
                    }
                }
            }
 
            int N = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            for (int i = 0; i < N; i++) {
                char command = temp.charAt(i);
 
                switch (command) {
                case 'U':
                    if(nx - 1 >= 0 && map[nx-1][ny] == '.') {
                        map[nx][ny] = '.';
                        map[nx-1][ny] = '^';
                        nx = nx -1;
                    }else {
                        map[nx][ny] = '^';
                    }
                    break;
                case 'D':
                    if(nx + 1 < H && map[nx+1][ny] == '.') {
                        map[nx][ny] = '.';
                        map[nx+1][ny] = 'v';
                        nx = nx +1;
                    }else {
                        map[nx][ny] = 'v';
                    }
                    break;
                case 'L':
                    if(ny - 1 >= 0 && map[nx][ny-1] == '.') {
                        map[nx][ny] = '.';
                        map[nx][ny-1] = '<';
                        ny = ny -1;
                    }else {
                        map[nx][ny] = '<';
                    }
                    break;
                case 'R':
                    if(ny +1 < W && map[nx][ny+1] == '.') {
                        map[nx][ny] = '.';
                        map[nx][ny+1] = '>';
                        ny = ny +1;
                    }else {
                        map[nx][ny] = '>';
                    }
                    break;
                case 'S':
                    char sht = map[nx][ny];
                    switch (sht) {
                    case '<':
                        for (int j = ny; j >= 0; j--) {
                            if(map[nx][j] == '*') {
                                map[nx][j] = '.';
                                break;
                            }else if(map[nx][j] == '#') 
                                break;
                             
                        }
                        break;
                    case '>':
                        for (int j = ny; j < W; j++) {
                            if(map[nx][j] == '*') {
                                map[nx][j] = '.';
                                break;
                            }else if(map[nx][j] == '#') 
                                break;
                        }
                        break;
                    case '^':
                        for (int j = nx; j >= 0; j--) {
                            if(map[j][ny] == '*') {
                                map[j][ny] = '.';
                                break;
                            }else if(map[j][ny] == '#') 
                                break;
                        }
                        break;
                    case 'v':
                        for (int j = nx; j < H; j++) {
                            if(map[j][ny] == '*') {
                                map[j][ny] = '.';
                                break;
                            }else if(map[j][ny] == '#') 
                                break;
                        }
                        break;
                    }
                    break;
                }
                 
            }
 
            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}