package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution5672 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            char[] arr = new char[N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().trim().charAt(0);
            }
 
            char[] result = new char[N];
 
            int s = -1; // ���ʿ��� ���ڸ� ���� �� �ֵ���
            int e = N; // ���ʺ��� ���ڸ� ���� �� �ֵ���
 
            for (int i = 0; i < N; i++) { // �Ѵܰ迡�� �Ѱ��� ���ϱ�
                if (arr[s + 1] < arr[e - 1]) {
                    result[i] = arr[++s];
                } else if (arr[s + 1] > arr[e - 1]) {
                    result[i] = arr[--e];
                } else { // �� ���ڰ� �������
                    int j;
                    for (j = 1; s + j < e - j && arr[s + j] == arr[e - j]; j++);
                    if (arr[s + j] < arr[e - j]) {
                        result[i] = arr[++s];
                    } else if (arr[s + j] > arr[e - j]) {
                        result[i] = arr[--e];
                    } else {
                        result[i] = arr[++s];
                    }
                }
 
            }
 
            sb.append("#").append(tc).append(" ").append(new String(result)).append("\n");
        }
        System.out.print(sb.toString());
    }
 
}