package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[N+1]; //0번방은 안씀
		int[] stack = new int[N]; // 스택, 탑의 index저장
		int top = -1;
		//String s = ""; // 최종 출력할 문자열
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			//스택에 나보다 작은 높이의 탑이 있으면 pop 꺼내버리기
			while(top > -1 && arr[stack[top]] < arr[i]) {
				top--; // 인덱스만 내림(삭제효과)
			}
			
			if(top==-1) {//스택이 비어있으면
				sb.append("0 ");
			}else {
				sb.append(stack[top] + " ");
			}
			//스택에 내 탑을 쌓기
			stack[++top] = i;
			
		}
		System.out.println(sb.toString());
	} 
} 
