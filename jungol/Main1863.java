package jungol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
  
public class Main1863 {
    static int nV;
    static int nE;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean isvisited[];
    static int cont;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
  
        nV=input.nextInt();
        nE=input.nextInt();
        adj=new ArrayList<ArrayList<Integer>>();
        isvisited=new boolean[nV];
        for(int i=0; i<=nV; i++)
            adj.add(new ArrayList<Integer>());
        for(int i=0; i<nV; i++)
            isvisited[i]=false;
        for(int i=0; i<nE; i++)
        {
            int t1=input.nextInt();
            int t2=input.nextInt();
  
            adj.get(t1).add(t2);
            adj.get(t2).add(t1);
        }
  
        int k=1;
  
        // 1부터 탐색시작
  
        for(int i=0; i<isvisited.length; i++)
        {
            if(isvisited[i]==false)
            {
                bfs(i+1);
                cont++;
            }
  
        }
         
        System.out.println(cont);
  
  
    }
  
    public static void bfs(int n)
    {
        Queue<Integer> q=new LinkedList<Integer>();
        q.offer(n);
         
        while(!q.isEmpty())
        {
            int t=q.poll();
  
            for(int i=0; i<adj.get(t).size(); i++)
            {
                if(isvisited[adj.get(t).get(i)-1]==false )
                {
                    isvisited[adj.get(t).get(i)-1]=true;
                    q.offer(adj.get(t).get(i));
                }
            }
  
        }
  
    }
}
