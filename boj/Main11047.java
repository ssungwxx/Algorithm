package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		int count = 0;
		Arrays.sort(arr);
		while(K > 0) {
			for(int i = N -1; i >=0 ; i--) {
				int temp = K / arr[i];
				K -= temp * arr[i];
				count += temp;
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}
}
