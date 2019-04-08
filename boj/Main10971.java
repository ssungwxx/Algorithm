package boj;

import java.util.*;

public class Main10971 {
    public static void main(String[] args) throws Exception {
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();
        int input[][] = new int[n][n];
        int array[] = new int[n];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = io.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            array[i] = i;
        }


        do {
            if(array[0] != 0) break;
            boolean check = true;
            int sum = 0;

            for(int i = 0 ; i < n-1; i++){
                if(input[array[i]][array[i+1]] == 0){
                    check = false;
                } else {
                    sum+= input[array[i]][array[i+1]];
                }
            }

            if(check && input[array[n-1]][array[0]] !=0){
                sum += input[array[n-1]][array[0]];
                if(sum < result) result = sum;
            }
        } while (next_permutation(array));

        System.out.println(result);

        io.close();
    }

    public static boolean next_permutation(int[] a) {
        int i = a.length - 1;
        int j = a.length - 1;
        int temp;

        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;

        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }
}
