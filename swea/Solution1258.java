package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution1258 {
 
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int xCnt;
    static int yCnt;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            LinkedList<box> list = new LinkedList<>();
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        xCnt = 1;
                        yCnt = 1;
                        bfs(i, j);
                        list.add(new box(xCnt, yCnt));
                        visit(i,j,xCnt, yCnt);
                    }
                }
            }
 
            Collections.sort(list, new Comparator<box>() {
                @Override
                public int compare(box o1, box o2) {
                    if(o1.sum == o2.sum) {
                        return (o1.xSize > o2.xSize) ? 1 : -1;
                    }
                    return (o1.sum > o2.sum) ? 1 : -1;
                }
            });
 
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(tc);
            sb.append(" ");
            sb.append(list.size());
            sb.append(" ");
            for (box item : list) {
                sb.append(item.xSize);
                sb.append(" ");
                sb.append(item.ySize);
                sb.append(" ");
            }
            System.out.println(sb.toString());
 
        }
    }
 
    public static void bfs(int x, int y) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x, y));
 
        while (!q.isEmpty()) {
            pair temp = q.poll();
            visited[temp.x][temp.y] = true;
 
            int nx = temp.x + 1;
            int ny = temp.y;
 
            if (nx < N && map[nx][ny] > 0 && !visited[nx][ny]) {
                q.add(new pair(nx, ny));
                xCnt++;
            }
 
        }
         
        visited[x][y] = false;
        q.add(new pair(x, y));
         
        while (!q.isEmpty()) {
            pair temp = q.poll();
            visited[temp.x][temp.y] = true;
 
            int nx = temp.x;
            int ny = temp.y + 1;
 
            if (ny < N && map[nx][ny] > 0 && !visited[nx][ny]) {
                q.add(new pair(nx, ny));
                yCnt++;
            }
        }
 
    }
     
    public static void visit(int x,int y, int xNum, int yNum) {
        for (int i = x; i < x+xNum; i++) {
            for (int j = y; j < y+yNum; j++) {
                visited[i][j] = true;
            }
        }
    }
 
    static class pair {
        int x;
        int y;
 
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    static class box {
        int xSize;
        int ySize;
        int sum;
 
        public box(int xSize, int ySize) {
            this.xSize = xSize;
            this.ySize = ySize;
            this.sum = xSize * ySize;
        }
    }
}