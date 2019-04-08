package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		boolean[] used = new boolean[N];
		for (int i = 0; i < N; i++) {
			used = new boolean[N];
			searchR:
			for (int j = 1; j < N; j++) { // 가로 길 조사
				
				if(map[i][j] == map[i][j-1] + 1) { // 전칸보다 올라옴
					for (int k = j-L; k < j; k++) {
						if(j-L < 0) break searchR; //범위초과시 탈출
						if(used[k]) break searchR; // 경사로 설치됫던곳일시 탈출
						if(map[i][k] != map[i][j-1]) break searchR; // 경사로 길이만큼 평평하지않는 경우 탈출
					}
					for (int k = j-L; k < j; k++) {
						used[k] = true;
					}
				}else if(map[i][j] == map[i][j-1] - 1 ) { // 전칸보다 내려옴
					for (int k = j; k < j+L; k++) {
						if(k >= N) break searchR; // 범위 초과시 탈출
						if(used[k]) break searchR; // 경사로 설치됫던곳일시 탈출
						else if(map[i][j] != map[i][k]) break searchR;
					}
					for (int k = j; k < j+L; k++) {
						used[k] = true;
					}
					j = j+L-1; // 앞경사로 생성되면 거기서부터 조사
				}else if (map[i][j] != map[i][j-1]) break searchR; // 윗 경우가 아니고 같지않는 경우에는 종료
				if(j==N-1) {
					cnt++; // 길끝까지 도착하면 카운트
				}
			}
		
			used = new boolean[N];
			searchC:
			for (int j = 1; j < N; j++) {
				
				if(map[j][i] == map[j-1][i] + 1) { // 전칸보다 올라옴
					for (int k = j-L; k < j; k++) {
						if(j-L < 0) break searchC; //범위초과시 탈출
						if(used[k]) break searchC; // 경사로 설치됫던곳일시 탈출
						if(map[k][i] != map[j-1][i]) break searchC; // 경사로 길이만큼 평평하지않는 경우 탈출
					}
					for (int k = j-L; k < j; k++) {
						used[k] = true;
					}
				}else if(map[j][i] == map[j-1][i] - 1 ) { // 전칸보다 내려옴
					for (int k = j; k < j+L; k++) {
						if(k >= N) break searchC; // 범위 초과시 탈출
						if(used[k]) break searchC; // 경사로 설치됫던곳일시 탈출
						else if(map[j][i] != map[k][i]) break searchC;
					}
					for (int k = j; k < j+L; k++) {
						used[k] = true;
					}
					j = j+L-1; // 앞경사로 생성되면 거기서부터 조사
				}else if (map[j][i] != map[j-1][i]) break searchC; // 윗 경우가 아니고 같지않는 경우에는 종료
				if(j==N-1) {
					cnt++; // 길끝까지 도착하면 카운트
				}
			}
		}
		
		System.out.println(cnt);
	}

}