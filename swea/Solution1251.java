package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Solution1251 {
    static class E implements Comparable<E> {
        int s, e;
        double w;
 
        public E(int s, int e, double w) {
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
 
    static int V, E;
    static ArrayList<E> edges;
    static int[] group;
 
    static void makeGroup() {
        for (int v = 0; v < V; v++) {
            group[v] = v;
        }
    }
 
    static int find(int a) {
        if (a == group[a])
            return a;
        return group[a] = find(group[a]);
    }
 
    static void union(int a, int b) {
        int ga = find(a);
        int gb = find(b);
 
        group[ga] = gb;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            double count = 0;
 
            V = Integer.parseInt(br.readLine());
             
            group = new int[V];
            edges = new ArrayList<E>();
 
            StringTokenizer stX = new StringTokenizer(br.readLine(), " ");
            StringTokenizer stY = new StringTokenizer(br.readLine(), " ");
            int[] x = new int[stX.countTokens()];
            int[] y = new int[stY.countTokens()];
 
            for (int i = 0; i < x.length; i++) {
                x[i] = Integer.parseInt(stX.nextToken());
                y[i] = Integer.parseInt(stY.nextToken());
            }
            double e = Double.parseDouble(br.readLine());
             
            for (int i = 0; i < x.length; i++) {
                for (int j = i; j < y.length; j++) {
                    if(i != j) {
                        double temp = (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2)) * e;
                        edges.add(new E(i,j,temp));
                    }
                }
            }
             
            makeGroup();
            Collections.sort(edges);
             
             
            int index = 0;
            for (int i = 0; i < V - 1; i++) {
                int start = edges.get(index).s;
                int end = edges.get(index).e;
                double weight = edges.get(index++).w;
                 
                if (find(start) != find(end)) {
                    union(start, end);
                    count += weight;
                }
                else
                    i--;
            }
 
            System.out.println("#" + tc + " " + Math.round(count));
        }
    }
}