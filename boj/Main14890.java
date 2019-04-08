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
			for (int j = 1; j < N; j++) { // ���� �� ����
				
				if(map[i][j] == map[i][j-1] + 1) { // ��ĭ���� �ö��
					for (int k = j-L; k < j; k++) {
						if(j-L < 0) break searchR; //�����ʰ��� Ż��
						if(used[k]) break searchR; // ���� ��ġ�̴����Ͻ� Ż��
						if(map[i][k] != map[i][j-1]) break searchR; // ���� ���̸�ŭ ���������ʴ� ��� Ż��
					}
					for (int k = j-L; k < j; k++) {
						used[k] = true;
					}
				}else if(map[i][j] == map[i][j-1] - 1 ) { // ��ĭ���� ������
					for (int k = j; k < j+L; k++) {
						if(k >= N) break searchR; // ���� �ʰ��� Ż��
						if(used[k]) break searchR; // ���� ��ġ�̴����Ͻ� Ż��
						else if(map[i][j] != map[i][k]) break searchR;
					}
					for (int k = j; k < j+L; k++) {
						used[k] = true;
					}
					j = j+L-1; // �հ��� �����Ǹ� �ű⼭���� ����
				}else if (map[i][j] != map[i][j-1]) break searchR; // �� ��찡 �ƴϰ� �����ʴ� ��쿡�� ����
				if(j==N-1) {
					cnt++; // �泡���� �����ϸ� ī��Ʈ
				}
			}
		
			used = new boolean[N];
			searchC:
			for (int j = 1; j < N; j++) {
				
				if(map[j][i] == map[j-1][i] + 1) { // ��ĭ���� �ö��
					for (int k = j-L; k < j; k++) {
						if(j-L < 0) break searchC; //�����ʰ��� Ż��
						if(used[k]) break searchC; // ���� ��ġ�̴����Ͻ� Ż��
						if(map[k][i] != map[j-1][i]) break searchC; // ���� ���̸�ŭ ���������ʴ� ��� Ż��
					}
					for (int k = j-L; k < j; k++) {
						used[k] = true;
					}
				}else if(map[j][i] == map[j-1][i] - 1 ) { // ��ĭ���� ������
					for (int k = j; k < j+L; k++) {
						if(k >= N) break searchC; // ���� �ʰ��� Ż��
						if(used[k]) break searchC; // ���� ��ġ�̴����Ͻ� Ż��
						else if(map[j][i] != map[k][i]) break searchC;
					}
					for (int k = j; k < j+L; k++) {
						used[k] = true;
					}
					j = j+L-1; // �հ��� �����Ǹ� �ű⼭���� ����
				}else if (map[j][i] != map[j-1][i]) break searchC; // �� ��찡 �ƴϰ� �����ʴ� ��쿡�� ����
				if(j==N-1) {
					cnt++; // �泡���� �����ϸ� ī��Ʈ
				}
			}
		}
		
		System.out.println(cnt);
	}

}