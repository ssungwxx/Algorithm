package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
 
public class Solution3124 {
    static class E implements Comparable<E> {
        int s, e, w;
 
        public E(int s, int e, int w) {
            super();
            this.s = s;
            this.e = e;
            this.w = w;
        }
 
        @Override
        public int compareTo(E o) {
            return (this.w < o.w) ? -1 : 1;
        }
    }
     
    static int V,E;
    static ArrayList<E> edges;
    static int[] group;
     
    static void makeGroup() {
        for (int v = 0; v < V; v++) {
            group[v] = v;
        }
    }
     
    static int find(int a) {
        if(a == group[a])
            return a;
        return group[a] = find(group[a]);
    }
     
    static void union(int a, int b) {
        int ga = find(a);
        int gb = find(b);
         
        group[ga] = gb;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
             
            group = new int[V];
            edges = new ArrayList<E>();
             
             
             
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int temp = Integer.parseInt(st.nextToken());
 
                edges.add(new E(x,y,temp));
            }
             
            makeGroup();
            Collections.sort(edges);
            long count = 0;
            int index = 0;
            for (int i = 0; i < V - 1; i++) {
                int start = edges.get(index).s;
                int end = edges.get(index).e;
                int weight = edges.get(index++).w;
                 
                if (find(start) != find(end)) {
                    union(start, end);
                    count += (long)weight;
                }
                else
                    i--;
            }
     
            System.out.println("#" + tc + " " + count);
        }
    }
}