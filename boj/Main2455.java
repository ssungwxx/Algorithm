package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2455 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int now = 0;
		int max = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			now -= Integer.parseInt(st.nextToken());
			now += Integer.parseInt(st.nextToken());
			max = (max < now)? now : max;
		}
		
		System.out.println(max);
	}
}
