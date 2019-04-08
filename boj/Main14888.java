package boj;

import java.util.*;

public class Main14888 {
    public static void main(String[] args) throws Exception {
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();
        int array[] = new int[n];
        List<String> op = new ArrayList<>();
        int oper[] = new int[n-1];


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i =0; i < n; i++){
            array[i] = io.nextInt();
        }

        for(int i=0; i<4; i++){
            int temp = io.nextInt();
            if(temp > 0){
                if(i == 0){
                    for(int j = 0; j<temp; j++){
                        op.add("0");
                    }
                }
                if(i == 1){
                    for(int j = 0; j<temp; j++){
                        op.add("1");
                    }
                }
                if(i == 2){
                    for(int j = 0; j<temp; j++){
                        op.add("2");
                    }
                }
                if(i == 3){
                    for(int j = 0; j<temp; j++){
                        op.add("3");
                    }
                }

            }

        }

        for(int i = 0; i < n-1 ; i++){
            oper[i] = Integer.parseInt(op.get(i));
        }

        do{
            int sum =array[0];
            for(int i =0; i < n-1; i++){
                if(oper[i] == 0) sum+=array[i+1];
                if(oper[i] == 1) sum-=array[i+1];
                if(oper[i] == 2) sum*=array[i+1];
                if(oper[i] == 3) sum/=array[i+1];
            }

            if(sum > max) max = sum;
            if(sum < min) min = sum;
        }while(next_permutation(oper));

        System.out.println(max);
        System.out.println(min);

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
