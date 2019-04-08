package jungol;

import java.util.Scanner;

public class Main2462 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N + 1][N + 1];
        int Infi = 10000000;
        int cnt = 0;
 
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j)
                    map[i][j] = Infi;
            }
        }
 
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
 
            map[a][b] = 1;
        }
         
        boolean[][] check = new boolean[N][N];
 
        for (int n = 1; n < map.length; n++) {
            int s = n; // ��������
            int[] D = map[s].clone(); // ����ġ �迭, ���������� ���������� ����ġ �迭 �ʱ�ȭ
            boolean[] used = new boolean[map.length];
             
            for (int i = 1; i < map.length; i++) { //���� �ϳ��� �����ϱ�
                //����������� �����߿���, ����ġ�� �ּ��� ������ ã�Ƽ� used�迭�� ���� �߰�
                int minIndex = 0; // �ּҰ���ġ�� ����� D�迭�� index
                int min = Infi; // �ּҰ���ġ
                for (int j = 1; j < D.length; j++) {
                    if(!used[j] && min > D[j]) {
                        minIndex = j;
                        min = D[j];
                    }
                }
                //����ġ�� �ּ��� ������ ã�� minIndex
                used[minIndex] = true;
                 
                //������ ������ ���ؼ� �� �� �ִ�(������ ����) ������ ����ġ�� �����ϱ�
                for (int j = 1; j < D.length; j++) {
                    //������� ���� ����, ������ ����, ����ġ�� ���ݺ��� �� ������ -> ����
                    if(!used[j] && map[minIndex][j] != M && D[j] > D[minIndex] + map[minIndex][j]) {
                        D[j] = D[minIndex] + map[minIndex][j];
                    }
                }
                 
            }
            for (int i = 1; i < D.length; i++) {
                if(D[i] > 0) check[n-1][i-1] = true;
            }
        }
        for (int i = 0; i < check.length; i++) {
            int temp = 0;
            for (int j = 0; j < check.length; j++) {
                if(i != j) {
                    if(check[i][j]) temp++;
                    if(check[j][i]) temp++;
                }
            }
            if(temp == N - 1) cnt++;
        }
        System.out.println(cnt);
    }
}