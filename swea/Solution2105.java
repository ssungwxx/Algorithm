package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Solution2105 {
     
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {-1, 1, 1, -1};
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int max;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            max = Integer.MIN_VALUE;
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    HashSet<Integer> li = new HashSet<>();
                    solve(i,j,li,0,0,0);
                }
            }
             
            sb.append("#").append(tc).append(" ");
            if(max == Integer.MIN_VALUE)
                sb.append("-1");
            else
                sb.append(max);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
 
    private static void solve(int x, int y, HashSet<Integer> li, int xCnt, int yCnt,int vec) {
        if(xCnt == 0 && yCnt == 0 && visited[x][y]) {
            max = max < li.size() ? li.size() : max;
            return;
        }
        visited[x][y] = true;
         
        switch (vec) {
        case 0:
            if(xCnt >= 0) {
                int nx = x + dx[vec];
                int ny = y + dy[vec];
                if(inRange(nx, ny) && !li.contains(map[nx][ny])) {
                    HashSet<Integer> temp = (HashSet<Integer>) li.clone();
                    temp.add(map[nx][ny]);
                    solve(nx,ny, temp,xCnt + 1, yCnt, vec);
                    temp.remove(map[nx][ny]);
                }
            }
            if(xCnt > 0) {
                int nx = x + dx[vec + 1];
                int ny = y + dy[vec + 1];
                if(inRange(nx, ny) && !li.contains(map[nx][ny])) {
                    HashSet<Integer> temp = (HashSet<Integer>) li.clone();
                    temp.add(map[nx][ny]);
                    solve(nx,ny, temp,xCnt, yCnt + 1, vec + 1);
                    temp.remove(map[nx][ny]);
                }
            }
            break;
        case 1:
            if(xCnt >= 0) {
                int nx = x + dx[vec];
                int ny = y + dy[vec];
                if(inRange(nx, ny) && !li.contains(map[nx][ny])) {
                    HashSet<Integer> temp = (HashSet<Integer>) li.clone();
                    temp.add(map[nx][ny]);
                    solve(nx,ny, temp,xCnt, yCnt + 1, vec);
                    temp.remove(map[nx][ny]);
                }
            }
            if(yCnt > 0) {
                int nx = x + dx[vec + 1];
                int ny = y + dy[vec + 1];
                if(inRange(nx, ny) && !li.contains(map[nx][ny])) {
                    HashSet<Integer> temp = (HashSet<Integer>) li.clone();
                    temp.add(map[nx][ny]);
                    solve(nx,ny, temp,xCnt - 1, yCnt, vec + 1);
                    temp.remove(map[nx][ny]);
                }
            }
            break;
        case 2:
            if(xCnt > 0) {
                int nx = x + dx[vec];
                int ny = y + dy[vec];
                if(inRange(nx, ny) && !li.contains(map[nx][ny])) {
                    HashSet<Integer> temp = (HashSet<Integer>) li.clone();
                    temp.add(map[nx][ny]);
                    solve(nx,ny, temp,xCnt - 1, yCnt, vec);
                    temp.remove(map[nx][ny]);
                }
            }else if(xCnt == 0){
                int nx = x + dx[vec + 1];
                int ny = y + dy[vec + 1];
                if(inRange(nx, ny) && !li.contains(map[nx][ny])) {
                    HashSet<Integer> temp = (HashSet<Integer>) li.clone();
                    temp.add(map[nx][ny]);
                    solve(nx,ny, temp,xCnt, yCnt - 1, vec + 1);
                    temp.remove(map[nx][ny]);
                }
            }
            break;
        case 3:
            if(yCnt > 0) {
                int nx = x + dx[vec];
                int ny = y + dy[vec];
                if(inRange(nx, ny) && !li.contains(map[nx][ny])) {
                    HashSet<Integer> temp = (HashSet<Integer>) li.clone();
                    temp.add(map[nx][ny]);
                    solve(nx,ny, temp,xCnt, yCnt - 1, vec);
                    temp.remove(temp.size() - 1);
                }
            }
            break;
        }
    }
     
    private static boolean inRange(int x, int y) {
        return x >=0 && x < N && y >=0 && y < N; 
    }
}