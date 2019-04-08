package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main1809 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        int[] arr = new int[N+1]; //0������ �Ⱦ�
        int[] stack = new int[N]; // ����, ž�� index����
        int top = -1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
             
            //���ÿ� ������ ���� ������ ž�� ������ pop ����������
            while(top > -1 && arr[stack[top]] < arr[i]) {
                top--; // �ε����� ����(����ȿ��)
            }
             
            if(top==-1) {//������ ���������
                System.out.print("0 ");
            }else {
                System.out.print(stack[top] + " ");
            }
            //���ÿ� �� ž�� �ױ�
            stack[++top] = i;
             
        }
        System.out.println();
    } 
}