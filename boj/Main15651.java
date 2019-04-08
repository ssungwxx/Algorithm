package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15651 {

	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			solve(i, 1, String.valueOf(i));
		}

	}

	private static void solve(int now, int cnt, String val) {
		if (cnt == M) {
			System.out.println(val);
			return;
			
		}
		for (int i = 1; i <= N; i++) {
			solve(i, cnt + 1, val + " " + i);
		}
	}
}
