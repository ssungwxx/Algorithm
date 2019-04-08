package boj;

import java.util.Scanner;

public class Main1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if (N < 100)
			System.out.println(N);
		else {
			int result = 99;
			for (int i = 100; i <= N; i++) {
				String temp = String.valueOf(i);
				int a = temp.charAt(0) - '0';
				int b = temp.charAt(1) - '0';
				int c = temp.charAt(2) - '0';
				
				if(a-b == b-c)
					result++;
			}
			System.out.println(result);
		}

		sc.close();
	}
}
