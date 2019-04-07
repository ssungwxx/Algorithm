package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution1953 {
 
    static int dx[] = { -1, 0, 1, 0, -1, 1, 0, 0, -1, 0, 1, 0, 1, 0, -1, 0 };
    static int dy[] = { 0, -1, 0, 1, 0, 0, -1, 1, 0, 1, 0, 1, 0, -1, 0, -1 };
    private static int N;
    private static int M;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
 
            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            Queue<pair> q = new LinkedList<>();
            q.add(new pair(R, C, L));
            visited[R][C] = true;
            int cnt = 1;
 
            while (!q.isEmpty()) {
                pair temp = q.poll();
                if(temp.l == 0) break;
 
                switch (map[temp.x][temp.y]) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        int nx = temp.x + dx[i];
                        int ny = temp.y + dy[i];
                        if (inRange(nx, ny) && temp.l > 1 && !visited[nx][ny]) {
                            if(i == 0 && !(map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6)) {
                                continue;
                            }else if(i == 1 && !(map[nx][ny] == 1 ||map[nx][ny] == 3 || map[nx][ny] == 4 ||map[nx][ny] == 5)) {
                                continue;
                            }else if(i == 2 && !(map[nx][ny] == 1 ||map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7)) {
                                continue;
                            }else if(i == 3 && !(map[nx][ny] == 1 ||map[nx][ny] ==3 || map[nx][ny] == 6 || map[nx][ny] == 7)) {
                                continue;
                            }
                            q.add(new pair(nx, ny, temp.l - 1));
                            cnt++;
                            visited[nx][ny] = true;                             
                        }
                    }
                    break;
 
                case 2:
                    for (int i = 4; i < 6; i++) {
                        int nx = temp.x + dx[i];
                        int ny = temp.y + dy[i];
                        if (inRange(nx, ny) && temp.l > 1 && !visited[nx][ny] && map[nx][ny] != 0) {
                            if(i == 4 && !(map[nx][ny] == 1 ||map[nx][ny] ==2 || map[nx][ny] == 5 || map[nx][ny] == 6)) {
                                break;
                            }else if(i == 5 && !(map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7)) {
                                break;
                            }
                            q.add(new pair(nx, ny, temp.l - 1));
                            cnt++;
                            visited[nx][ny] = true;
                        }
                    }
                    break;
 
                case 3:
                    for (int i = 6; i < 8; i++) {
                        int nx = temp.x + dx[i];
                        int ny = temp.y + dy[i];
                        if (inRange(nx, ny) && temp.l > 1 && !visited[nx][ny] && map[nx][ny] != 0) {
                            if(i == 6 && !(map[nx][ny] == 1 ||map[nx][ny] == 3 || map[nx][ny] == 4 ||map[nx][ny] == 5)) {
                                break;
                            }else if(i == 7 && !(map[nx][ny] == 1 ||map[nx][ny] ==3 || map[nx][ny] == 6 || map[nx][ny] == 7)) {
                                break;
                            }
                             
                            q.add(new pair(nx, ny, temp.l - 1));
                            cnt++;
                            visited[nx][ny] = true;
                        }
                    }
                    break;
 
                case 4:
                    for (int i = 8; i < 10; i++) {
                        int nx = temp.x + dx[i];
                        int ny = temp.y + dy[i];
                        if (inRange(nx, ny) && temp.l > 1 && !visited[nx][ny] && map[nx][ny] != 0) {
                            if(i == 8 && !(map[nx][ny] == 1 ||map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6)) {
                                continue;
                            }else if(i == 9 && !(map[nx][ny] == 1 ||map[nx][ny] ==3 || map[nx][ny] == 6 || map[nx][ny] == 7)) {
                                continue;
                            }
                             
                            q.add(new pair(nx, ny, temp.l - 1));
                            cnt++;
                            visited[nx][ny] = true;
                        }
                    }
                    break;
 
                case 5:
                    for (int i = 10; i < 12; i++) {
                        int nx = temp.x + dx[i];
                        int ny = temp.y + dy[i];
                        if (inRange(nx, ny) && temp.l > 1 && !visited[nx][ny] && map[nx][ny] != 0) {
                            if(i == 10 && !(map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7)) {
                                continue;
                            }else if(i == 11 && !(map[nx][ny] == 1 ||map[nx][ny] ==3 || map[nx][ny] == 6 || map[nx][ny] == 7)) {
                                continue;
                            }
                             
                            q.add(new pair(nx, ny, temp.l - 1));
                            cnt++;
                            visited[nx][ny] = true;
                        }
                    }
                    break;
 
                case 6:
                    for (int i = 12; i < 14; i++) {
                        int nx = temp.x + dx[i];
                        int ny = temp.y + dy[i];
                        if (inRange(nx, ny) && temp.l > 1 && !visited[nx][ny] && map[nx][ny] != 0) {
                            if(i == 12 && !(map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7)) {
                                continue;
                            }else if(i ==13 && !(map[nx][ny] == 1 ||map[nx][ny] == 3 || map[nx][ny] == 4 ||map[nx][ny] == 5)) {
                                continue;
                            }
                             
                            q.add(new pair(nx, ny, temp.l - 1));
                            cnt++;
                            visited[nx][ny] = true;
                        }
                    }
                    break;
 
                case 7:
                    for (int i = 14; i < 16; i++) {
                        int nx = temp.x + dx[i];
                        int ny = temp.y + dy[i];
                        if (inRange(nx, ny) && temp.l > 1 && !visited[nx][ny] && map[nx][ny] != 0) {
                            if(i == 14 && !(map[nx][ny] == 1 ||map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6)) {
                                continue;
                            }else if(i == 15 && !(map[nx][ny] == 1 ||map[nx][ny] == 3 || map[nx][ny] == 4 ||map[nx][ny] == 5)) {
                                continue;
                            }
                             
                            q.add(new pair(nx, ny, temp.l - 1));
                            cnt++;
                            visited[nx][ny] = true;
                        }
                    }
                    break;
 
                }
            }
 
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
 
        System.out.print(sb.toString());
    }
 
    private static class pair {
        int x, y, l;
 
        public pair(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }
 
    private static boolean inRange(int x, int y) {
        return x < N && x >= 0 && y < M && y >= 0;
    }
}