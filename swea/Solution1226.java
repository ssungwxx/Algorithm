package swea;

import java.util.Scanner;

public class Solution1226 {
     
    static int[][] map = new int[16][16];
    static int[][] visited;
    static boolean check = false;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
         
        for(int k = 0; k < 10 ; k++) {
            int tc = Integer.parseInt(sc.nextLine());
             
            visited = new int[16][16];
            check = false;
             
            for(int i = 0; i < 16; i++) {
                String temp = sc.nextLine();
                for(int j = 0; j < 16; j++) {
                    map[i][j] = temp.charAt(j) - '0';
                    if(map[i][j] == 1)
                        visited[i][j] = 1;
                }
            }
             
            solve(1,1);
             
            if(check) {
                System.out.println("#"+ tc + " 1");
            }else {
                System.out.println("#"+ tc + " 0");
            }
             
        }
         
        sc.close();
    }
     
    public static void solve(int x, int y) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1 ,-1 , 0};
         
        for(int i = 0; i < 4; i++) {
            if(map[x+dx[i]][y+dy[i]] == 0) {
                if(visited[x+dx[i]][y+dy[i]] == 0) {
                    visited[x+dx[i]][y+dy[i]] = 1;
                    solve(x+dx[i],y+dy[i]);
                }
            }else if(map[x+dx[i]][y+dy[i]] == 3){
                check = true;
            }
                 
        }
    }
}