package boj;

import java.util.*;

public class Main1476 {
    public static void main(String[] args) throws Exception {
        Scanner io = new Scanner(System.in);

        int E = io.nextInt();
        int S = io.nextInt();
        int M = io.nextInt();

        int i = 1;
        int j = 1;
        int k = 1;

        int year = 1;

        while (true) {
            if (i > 15) i = 1;
            if (j > 28) j = 1;
            if (k > 19) k = 1;


            if (i == E && j == S && k == M) {
                System.out.println(year);
                break;
            }

            year++;
            i++;
            j++;
            k++;
        }

        io.close();
    }
}