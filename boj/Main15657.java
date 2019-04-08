package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15657 {

	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			solve(i, 1, String.valueOf(arr[i]));
		}

	}

	private static void solve(int now, int cnt, String val) {
		if (cnt == M) {
			System.out.println(val);
			return;

		}
		for (int i = now; i < N; i++) {
			solve(i, cnt + 1, val + " " + arr[i]);
		}
	}
}
