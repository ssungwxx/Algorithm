package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution1824 {
 
    private static char[][] map;
    private static int R;
    private static int C;
    private static boolean flag;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { 1, -1, 0, 0 };
    private static boolean[][][] visitedVec;
    private static boolean[][][] visitedMem;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
 
            map = new char[R][C];
 
            for (int i = 0; i < R; i++) {
                String str = br.readLine().trim();
                for (int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
 
            flag = false;
            visitedVec = new boolean[R][C][4];
            visitedMem = new boolean[R][C][16];
            solve(0, 0, 0, 0);
 
            sb.append("#").append(tc).append(" ");
            if (flag)
                sb.append("YES");
            else
                sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb.toString());
 
    }
 
    private static void solve(int r, int c, int mem, int vec) {
        if (map[r][c] == '@') {
            flag = true;
            return;
        }
        if (visitedMem[r][c][mem] && visitedVec[r][c][vec])
            return;
 
        visitedMem[r][c][mem] = true;
        visitedVec[r][c][vec] = true;
        int nx = r + dx[vec];
        int ny = c + dy[vec];
        if (ny < 0)
            ny = C - 1;
        if (ny == C)
            ny = 0;
        if (nx < 0)
            nx = R - 1;
        if (nx == R)
            nx = 0;
         
 
        switch (map[r][c]) {
        case '<':
            nx = r + dx[1];
            ny = c + dy[1];
            if (ny < 0)
                ny = C - 1;
            solve(nx, ny, mem, 1);
            break;
        case '>':
            nx = r + dx[0];
            ny = c + dy[0];
            if (ny >= C)
                ny = 0;
            solve(nx, ny, mem, 0);
            break;
        case '^':
            nx = r + dx[2];
            ny = c + dy[2];
            if (nx < 0)
                nx = R - 1;
            solve(nx, ny, mem, 2);
            break;
        case 'v':
            nx = r + dx[3];
            ny = c + dy[3];
            if (nx >= R)
                nx = 0;
            solve(nx, ny, mem, 3);
            break;
        case '+':
            if (mem + 1 > 15)
                solve(nx, ny, 0, vec);
            else
                solve(nx, ny, mem + 1, vec);
            break;
        case '-':
            if (mem - 1 < 0)
                solve(nx, ny, 15, vec);
            else
                solve(nx, ny, mem - 1, vec);
            break;
        case '.':
            solve(nx, ny, mem, vec);
            break;
        case '_':
            if (mem == 0) {
                nx = r + dx[0];
                ny = c + dy[0];
                if (ny == C)
                    ny = 0;
                solve(nx, ny, mem, 0);
            } else {
                nx = r + dx[1];
                ny = c + dy[1];
                if (ny < 0)
                    ny = C - 1;
                solve(nx, ny, mem, 1);
            }
            break;
        case '|':
            if (mem == 0) {
                nx = r + dx[3];
                ny = c + dy[3];
                if (nx >= R)
                    nx = 0;
                solve(nx, ny, mem, 3);
            } else {
                nx = r + dx[2];
                ny = c + dy[2];
                if (nx < 0)
                    nx = R - 1;
                solve(nx, ny, mem, 2);
            }
            break;
        case '?':
            nx = r + dx[1];
            ny = c + dy[1];
            if (ny < 0)
                ny = C - 1;
            solve(nx, ny, mem, 1);
            nx = r + dx[0];
            ny = c + dy[0];
            if (ny == C)
                ny = 0;
            solve(nx, ny, mem, 0);
            nx = r + dx[2];
            ny = c + dy[2];
            if (nx < 0)
                nx = R - 1;
            solve(nx, ny, mem, 2);
            nx = r + dx[3];
            ny = c + dy[3];
            if (nx == R)
                nx = 0;
            solve(nx, ny, mem, 3);
            break;
        default:
            solve(nx, ny, map[r][c] - '0', vec);
        }
 
    }
}