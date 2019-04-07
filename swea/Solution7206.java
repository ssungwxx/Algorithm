package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution7206 {

	public static HashMap<Integer, Integer> hm;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		long time = System.currentTimeMillis();
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());

			hm = new HashMap<Integer, Integer>(); // 초기화
			System.out.println("#" + tc + " " + f(N));
		}
		System.out.println(System.currentTimeMillis() - time + "ms");
	}

// 턴이 있을 경우, 숫자를 쪼개는 모든경우를 구해서, 그중 최대값을 찾아서 리턴
	public static int f(int n) {
		if (n < 10) {
			return 0;
		}
//int len = (int)Math.log10(n) + 1; //최대 쪼갤 수 있는 포인트 로그를 이용하여 자릿수 구하기
		String s = "" + n;
		int len = s.length() - 1;

		int maxCnt = 0;

		for (int i = 1; i < 1 << len; i++) { // 쪼갤수 있는 모든 경우, 바이너리 카운팅 이용
			int mul = 1; // 곱셈값을 저장할 변수, 곱셈연산자에 대한 항등원으로 1로 초기화
			int num = s.charAt(0) - '0';
			for (int j = 0; j < len; j++) { // 비트마스킹, 해당 비트가 1이면 쪼갬, 0이면 안쪼갬 이어붙임
				if ((i & 1 << j) == 0) { // 쪼갬
					num = num * 10 + s.charAt(j + 1) - '0';
				} else { // 안쪼갬
					mul *= num;
					num = s.charAt(j + 1) - '0'; // 새로운 문자로 저장
				}
			}
			mul *= num;
//int cnt = f(mul); // 많은 중복이 발생하기에 memorization활용
			int cnt;
			if (hm.containsKey(mul)) { // 이미 호출한 기록이 있으면, 재활용
				cnt = hm.get(mul);
			} else {
				cnt = f(mul);
				hm.put(mul, cnt);
			}
			if (maxCnt < cnt) {
				maxCnt = cnt;
			}
		}

		return maxCnt + 1;
	}
}