package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Solution4261 {
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('a', 2); hm.put('b', 2); hm.put('c', 2); hm.put('d', 3); hm.put('e', 3); hm.put('f', 3); 
        hm.put('g', 4); hm.put('h', 4); hm.put('i', 4); hm.put('j', 5); hm.put('k', 5); hm.put('l', 5); 
        hm.put('m', 6); hm.put('n', 6); hm.put('o', 6); hm.put('p', 7); hm.put('q', 7); hm.put('r', 7); hm.put('s', 7); 
        hm.put('t', 8); hm.put('u', 8); hm.put('v', 8); hm.put('w', 9); hm.put('x', 9); hm.put('y', 9); hm.put('z', 9); 
         
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int cnt = 0;
             
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            String str = st.nextToken();
            int N = Integer.parseInt(st.nextToken().trim());
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int i = 0; i < N; i++) {
                String temp = st.nextToken();
                String n= "";
                for (int j = 0; j < temp.length(); j++) {
                    n += hm.get(temp.charAt(j));
                    String sub = str.substring(0, j+1);
                    if(!sub.equals(n)) break;
                }
                if(str.equals(n)) cnt++;
            }
 
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}