package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i] <= B) {
				sum += 1;
			} else if((A[i] - B) % C == 0) {
				sum += (A[i] - B) / C + 1;
			} else if((A[i] - B) % C != 0) {
				sum += (A[i] - B) / C + 2;
			}
		}
		System.out.println(sum);
	}
}
