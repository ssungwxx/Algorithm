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
            int s = n; // 시작정점
            int[] D = map[s].clone(); // 가중치 배열, 시작정점의 진출차수로 가중치 배열 초기화
            boolean[] used = new boolean[map.length];
             
            for (int i = 1; i < map.length; i++) { //정렬 하나씩 선택하기
                //사용하지않은 정점중에서, 가중치가 최소인 정점을 찾아서 used배열에 정점 추가
                int minIndex = 0; // 최소가중치가 저장된 D배열의 index
                int min = Infi; // 최소가중치
                for (int j = 1; j < D.length; j++) {
                    if(!used[j] && min > D[j]) {
                        minIndex = j;
                        min = D[j];
                    }
                }
                //가중치가 최소인 정점을 찾음 minIndex
                used[minIndex] = true;
                 
                //선택한 정점을 통해서 갈 수 있는(인접한 정렬) 정점의 가중치를 갱신하기
                for (int j = 1; j < D.length; j++) {
                    //사용하지 않은 정점, 인접한 정점, 가중치가 지금보다 더 작으면 -> 갱신
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