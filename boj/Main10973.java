package boj;

import java.util.*;

public class Main10973 {
    public static void main(String[] args) throws Exception {
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        int array[] = new int[n];

        if (n >= 1 && n <= 10000) {
            for (int i = 0; i < n; i++) {
                array[i] = io.nextInt();
            }

            if (pre_permutation(array)) {
                for (int i = 0; i < n; i++) {
                    System.out.print(array[i] + " ");
                }
            } else {
                System.out.println(-1);
            }
        }


        io.close();
    }

    public static boolean pre_permutation(int[] a) {
        int i = a.length - 1;
        int j = a.length - 1;
        int temp;

        while (i > 0 && a[i - 1] <= a[i]) {
            i-=1;
        }

        if (i <= 0) {
            return false;
        }

        while (a[j] >= a[i - 1]) {
            j-=1;
        }

        temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length-1;

        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i+=1;
            j-=1;
        }

        return true;
    }
}