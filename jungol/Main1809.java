package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main1809 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        int[] arr = new int[N+1]; //0번방은 안씀
        int[] stack = new int[N]; // 스택, 탑의 index저장
        int top = -1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
             
            //스택에 나보다 작은 높이의 탑이 있으면 pop 꺼내버리기
            while(top > -1 && arr[stack[top]] < arr[i]) {
                top--; // 인덱스만 내림(삭제효과)
            }
             
            if(top==-1) {//스택이 비어있으면
                System.out.print("0 ");
            }else {
                System.out.print(stack[top] + " ");
            }
            //스택에 내 탑을 쌓기
            stack[++top] = i;
             
        }
        System.out.println();
    } 
}