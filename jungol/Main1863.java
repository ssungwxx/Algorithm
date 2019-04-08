package jungol;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main1863 {
    static int n, m;
    static int[] map;
    static int cnt;
     
    public static void makeSet(int x) {
        map[x] = x;
    }
     
    public static int findSet(int x) {
        if ( x == map[x] ) 
            return x;
        else {
            map[x] = findSet(map[x]); 
            return map[x];
        }
    }
     
    public static void union(int x, int y) {
        int px = findSet(x); 
        int py = findSet(y);
         
        if (px != py) { 
            map[py] = px;
            cnt--;
        }
     
    }
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
         
        map = new int[n+1];
         
        cnt = n;
         
        for (int i = 0; i < map.length; i++) {
            makeSet(i);
        }
         
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
             
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
             
            union(s1, s2);
        }
         
        System.out.println(cnt);
    }
     
}