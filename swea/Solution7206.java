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

			hm = new HashMap<Integer, Integer>(); // �ʱ�ȭ
			System.out.println("#" + tc + " " + f(N));
		}
		System.out.println(System.currentTimeMillis() - time + "ms");
	}

// ���� ���� ���, ���ڸ� �ɰ��� ����츦 ���ؼ�, ���� �ִ밪�� ã�Ƽ� ����
	public static int f(int n) {
		if (n < 10) {
			return 0;
		}
//int len = (int)Math.log10(n) + 1; //�ִ� �ɰ� �� �ִ� ����Ʈ �α׸� �̿��Ͽ� �ڸ��� ���ϱ�
		String s = "" + n;
		int len = s.length() - 1;

		int maxCnt = 0;

		for (int i = 1; i < 1 << len; i++) { // �ɰ��� �ִ� ��� ���, ���̳ʸ� ī���� �̿�
			int mul = 1; // �������� ������ ����, ���������ڿ� ���� �׵������ 1�� �ʱ�ȭ
			int num = s.charAt(0) - '0';
			for (int j = 0; j < len; j++) { // ��Ʈ����ŷ, �ش� ��Ʈ�� 1�̸� �ɰ�, 0�̸� ���ɰ� �̾����
				if ((i & 1 << j) == 0) { // �ɰ�
					num = num * 10 + s.charAt(j + 1) - '0';
				} else { // ���ɰ�
					mul *= num;
					num = s.charAt(j + 1) - '0'; // ���ο� ���ڷ� ����
				}
			}
			mul *= num;
//int cnt = f(mul); // ���� �ߺ��� �߻��ϱ⿡ memorizationȰ��
			int cnt;
			if (hm.containsKey(mul)) { // �̹� ȣ���� ����� ������, ��Ȱ��
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