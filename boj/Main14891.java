package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14891 {
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int K = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			String vec = st.nextToken();

			if (vec.equals("1")) {
				if(num-1 >= 0 && arr[num][6] != arr[num-1][2]) left(num-1,false);
				right(num, true);
			} else { // vec = -1 반시계 방향
				if(num+1<4 && arr[num][2] != arr[num+1][6]) right(num+1, true);
				left(num, false);
			}

		}
		int sum = 0;
		if(arr[0][0] == 1) sum+=1;
		if(arr[1][0] == 1) sum+=2;
		if(arr[2][0] == 1) sum+=4;
		if(arr[3][0] == 1) sum+=8;
		System.out.println(sum);

	}

	static void right(int n, boolean flag) { // flag true -> right  false -> left
		if(flag) {
			if(n+1<4 && arr[n][2] != arr[n+1][6]) left(n+1,true);
		}else {
			if(n-1>=0 && arr[n][6] != arr[n-1][2]) left(n-1,false);
		}
		int temp = arr[n][7];
		for (int i = 7; i > 0; i--) {
			arr[n][i] = arr[n][i-1];
		}
		arr[n][0] = temp;
		
	}

	static void left(int n, boolean flag) {
		if(flag) {
			if(n+1<4 && arr[n][2] != arr[n+1][6]) right(n+1,true);
		}else {
			if(n-1>=0 && arr[n][6] != arr[n-1][2]) right(n-1,false);
		}
		int temp = arr[n][0];
		for (int i = 0; i < 7; i++) {
			arr[n][i] = arr[n][i+1];
		}
		arr[n][7] = temp;

	}
}