package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Main2247 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
 
        pair[] people = new pair[N];
         
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long S = Long.parseLong(st.nextToken());
            long E = Long.parseLong(st.nextToken());
            people[i] = new pair(S, E);
        }
         
        Arrays.sort(people, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return (o1.start < o2.start) ? -1 : 1;
            }
        });
         
         
        long any = 0;
        long blank = people[0].start-1;
        long temp = 0;
        long s = people[0].start;
        long e = people[0].end;
        for (int i = 1; i < people.length; i++) {
            if(people[i].start <= e) {
                e = (e < people[i].end) ? people[i].end : e ;
                temp = e - s;
                any = (any < temp) ? temp : any;
            }else {
                long temp2 = people[i].start - e;
                blank = (blank < temp2) ? temp2 : blank;
                s = people[i].start;
                e = people[i].end;
                 
            }
        }
 
 
         
        System.out.println(any + " " + blank);
    }
     
    static class pair{
        long start;
        long end;
        public pair(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}