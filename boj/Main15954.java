package boj;

import java.util.*;

public class Main15954 {

    private static void cal(int dollCnt, int like, int doll[]) {


        int sum[] = new int[dollCnt + 1];

        for (int i = 1; i <= dollCnt; i++)
            sum[i] = sum[i - 1] + doll[i];

        double min = Double.MAX_VALUE;

        for (int i = 1; i <= dollCnt - like + 1; i++) {
            for (int j = i + like - 1; j <= dollCnt; j++) {
                double n = j - i + 1;
                double avg = (sum[j] - sum[i - 1]) / n;

                double dis = 0;

                for (int k = i; k <= j; k++)
                    dis += (doll[k] - avg) * (doll[k] - avg);

                dis = Math.sqrt(dis / n);
                min = Math.min(min, dis);

            }
        }

        System.out.print(min);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int dollCnt = sc.nextInt();
        int like = sc.nextInt();
        int doll[] = new int[dollCnt + 1];

        for (int i = 1; i <= dollCnt; i++) {
            doll[i] = sc.nextInt();
        }

        cal(dollCnt, like, doll);

        sc.close();
    }
}