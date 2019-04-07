package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution3378 {
    private static String[] prr;
    private static String[] qrr;
    private static int[] result;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            prr = new String[p]; // �������ڵ�
            qrr = new String[q]; // �����ڵ�
            result = new int[q]; // ����� ��� ������ �迭
            Arrays.fill(result, -2); // �迭�� �ʱⰪ�� ������� �ʴ� ���� -2�� �ʱ�ȭ
 
            for (int i = 0; i < p; i++) {
                prr[i] = br.readLine(); // ������ �ִ� 80��
            }
            for (int i = 0; i < q; i++) {
                qrr[i] = br.readLine();
            }
 
            for (int r = 1; r < 21; r++) {
                for (int c = 1; c < 21; c++) {
                    for (int s = 1; s < 21; s++) {
                        if (pOk(r, c, s)) { // �������� ��� �ڵ带 �����ϴ� ������ üũ
                            // ������ ��� �ڵ� �࿡�� �������� üũ �� �迭�� ����
                            qOk(r, c, s);
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc);
            for (int i = 0; i < result.length; i++) {
                sb.append(" ").append(result[i]);
            }
            System.out.println(sb.toString());
        }
    }
 
    //������ ��� �� �࿡�� �������� üũ �� �迭�� ����
    private static void qOk(int r, int c, int s) {
        int rr = 0;
        int cc = 0;
        int ss = 0;
        for (int i = 0; i < qrr.length; i++) {
            int dap = r *rr + c * cc + s*ss;
             
            if(result[i] == -2) {
                result[i] = dap;                
            }else if(result[i] >= 0 && result[i] != dap){ //�������� ���� ������ ��Ȳ
                result[i] = -1;
            }
             
            String str = qrr[i];
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '(') rr++;
                else if(str.charAt(j) == ')') rr--;
                else if(str.charAt(j) == '{')  cc++;
                else if(str.charAt(j) == '}') cc--;
                else if(str.charAt(j) == '[') ss++;
                else if(str.charAt(j) == ']') ss--;
            }
        }
    }
 
    // ������ �ڵ��� ��� �ڵ带 �����ϴ� ������ üũ
    private static boolean pOk(int r, int c, int s) {
        int rr = 0; // ()�� ����
        int cc = 0; // {}�� ����
        int ss = 0; // []�� ����
         
        for (int i = 0; i < prr.length; i++) {
            int dot = 0; //.�� ����
            String str = prr[i];
            int j;
            for (j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '.') dot++;
                else break; // �ٸ����ڰ� ���� �� ����������
            }
             
            if(r*rr + c*cc + s*ss != dot) return false;
             
            for (; j < str.length(); j++) { // . ���� ���ڸ� �������� �о��
                if(str.charAt(j) == '(') rr++;
                else if(str.charAt(j) == ')') rr--;
                else if(str.charAt(j) == '{')  cc++;
                else if(str.charAt(j) == '}') cc--;
                else if(str.charAt(j) == '[') ss++;
                else if(str.charAt(j) == ']') ss--;
            }
             
        }
 
        return true;
    }
}