package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution1868 {
 
    static int[] dx = { 0, 0, -1, -1, -1, 1, 1, 1 };
    static int[] dy = { -1, 1, 0, 1, -1, 0, 1, -1 };
    static char[][] map;
    static int N;
    static int result;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
 
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
 
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
 
            result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') {
                        int cnt = 0;
                        for (int k = 0; k < 8; k++) {
                            if (i + dx[k] >= 0 && i + dx[k] < N && j + dy[k] >= 0 && j + dy[k] < N) {
                                if (map[i + dx[k]][j + dy[k]] == '*')
                                    cnt++;
                            }
                        }
                        map[i][j] = (char) (cnt + '0');
                    }
                }
            }
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '0') {
                        mapping(i,j);
                        result++;
                    }
                }
            }
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] != '*' && map[i][j] != 'M') {
                        map[i][j] = 'M';
                        result++;
                    }
                }
            }
 
            System.out.println("#" + tc + " " + result);
        }
    }
 
    public static void mapping(int x, int y) {
        if(map[x][y] != '0') return;
        else map[x][y] = 'M';
        for (int i = 0; i < 8; i++) {
            if(x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N) {
                if(map[x+dx[i]][y+dy[i]] == '0') {
                    mapping(x+dx[i], y+dy[i]);
                }else if(map[x+dx[i]][y+dy[i]] != 'M' && map[x+dx[i]][y+dy[i]] != '*') {
                    map[x+dx[i]][y+dy[i]] = 'M';
                }
            }
        }
    }
}