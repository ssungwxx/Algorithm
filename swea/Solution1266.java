package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1266 {
	static int[] sosu = { 2, 3, 5, 7, 11, 13, 17 };
	static long[] fac = new long[19];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double skillOfMasterA = Long.parseLong(st.nextToken());
			double skillOfMasterB = Long.parseLong(st.nextToken());
			factorial(18);
			double res_a = cal(skillOfMasterA);
			double res_b = cal(skillOfMasterB);
			double res = res_a + res_b - res_a * res_b;
			System.out.print("#" + tc + " ");
			System.out.format("%.6f%n", res);
		}
	}

	public static double cal(double a) {
		if (a == 0)
			return 0;
		double p = (double) a / 100;
		double[] P = new double[19];
		double[] Q = new double[19];
		P[1] = p;
		Q[1] = 1 - p;
		for (int i = 2; i < 18; i++) {
			P[i] = P[i - 1] * p;
			Q[i] = Q[i - 1] * (1 - p);
		}
		double res = 0;
		for (int i = 0; i < 7; i++) {
			res += composition(18, sosu[i]) * P[sosu[i]] * Q[18 - sosu[i]];
		}
		return res;
	}

	public static double composition(int n, int r) {
		if (r == 0 || r == n)
			return 1;
		long res = fac[n] / fac[r];
		res /= fac[n - r];
		return res;
	}

	public static long factorial(int n) {
		if (n == 1) {
			fac[0] = 0;
			fac[1] = 1;
			return 1;
		}
		long res = n * factorial(n - 1);
		fac[n] = res;
		return res;
	}
}