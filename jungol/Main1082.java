package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main1082 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
  
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
         
        char[][] map = new char[R][C];
        int[][] visited = new int[R][C];
         
        Queue<pair> fq = new LinkedList<>();
        Queue<pair> pq = new LinkedList<>();
         
  
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '*') {
                    fq.add(new pair(i,j));
                }
                if(map[i][j] == 'S') {
                    pq.add(new pair(i,j));
                }
            }
        }
         
        int time = 0;
        while(!pq.isEmpty()) {
            pair temp = pq.poll();
            int x = temp.x;
            int y = temp.y;
             
            if(visited[x][y] != time) {
                time = visited[x][y];
                int size = fq.size();
                 
                for (int i = 0; i < size; i++) {
                    pair ftemp = fq.poll();
                    int fx = ftemp.x;
                    int fy = ftemp.y;
                     
                    for (int j = 0; j < 4; j++) {
                        int nx = fx + dx[j];
                        int ny = fy + dy[j];
                         
                        if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            if(map[nx][ny] == '.') {
                                map[nx][ny] = '*';
                                fq.add(new pair(nx,ny));
                            }
                        }
                    }
                }
            }
            if(map[x][y] == '*') continue;
             
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                 
                if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if(map[nx][ny] == 'D') {
                        System.out.println(visited[x][y] + 1);
                        return;
                    }
                     
                    if(map[nx][ny] == '.' && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[x][y] + 1;
                        pq.add(new pair(nx,ny));
                    }
                }
                 
            }
        }        
         
        System.out.println("impossible");
    }
     
    static class pair{
        int x;
        int y;
 
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}