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
		
		int[] arr = new int[N+1]; //0������ �Ⱦ�
		int[] stack = new int[N]; // ����, ž�� index����
		int top = -1;
		//String s = ""; // ���� ����� ���ڿ�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			//���ÿ� ������ ���� ������ ž�� ������ pop ����������
			while(top > -1 && arr[stack[top]] < arr[i]) {
				top--; // �ε����� ����(����ȿ��)
			}
			
			if(top==-1) {//������ ���������
				sb.append("0 ");
			}else {
				sb.append(stack[top] + " ");
			}
			//���ÿ� �� ž�� �ױ�
			stack[++top] = i;
			
		}
		System.out.println(sb.toString());
	} 
} 
