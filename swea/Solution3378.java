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
            prr = new String[p]; // 마스터코드
            qrr = new String[q]; // 유저코드
            result = new int[q]; // 출력할 결과 저장할 배열
            Arrays.fill(result, -2); // 배열의 초기값을 사용하지 않는 숫자 -2로 초기화
 
            for (int i = 0; i < p; i++) {
                prr[i] = br.readLine(); // 각줄은 최대 80자
            }
            for (int i = 0; i < q; i++) {
                qrr[i] = br.readLine();
            }
 
            for (int r = 1; r < 21; r++) {
                for (int c = 1; c < 21; c++) {
                    for (int s = 1; s < 21; s++) {
                        if (pOk(r, c, s)) { // 마스토의 모든 코드를 만족하는 값인지 체크
                            // 유저의 모든 코드 행에서 가능한지 체크 후 배열에 저장
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
 
    //유저의 모든 콛 행에서 가능한지 체크 후 배열에 저장
    private static void qOk(int r, int c, int s) {
        int rr = 0;
        int cc = 0;
        int ss = 0;
        for (int i = 0; i < qrr.length; i++) {
            int dap = r *rr + c * cc + s*ss;
             
            if(result[i] == -2) {
                result[i] = dap;                
            }else if(result[i] >= 0 && result[i] != dap){ //여러가지 값이 들어오는 상황
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
 
    // 마스터 코드의 모든 코드를 만족하는 값인지 체크
    private static boolean pOk(int r, int c, int s) {
        int rr = 0; // ()의 개수
        int cc = 0; // {}의 개수
        int ss = 0; // []의 개수
         
        for (int i = 0; i < prr.length; i++) {
            int dot = 0; //.의 개수
            String str = prr[i];
            int j;
            for (j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '.') dot++;
                else break; // 다른글자가 나올 시 빠져나오기
            }
             
            if(r*rr + c*cc + s*ss != dot) return false;
             
            for (; j < str.length(); j++) { // . 읽은 글자를 다음부터 읽어가기
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