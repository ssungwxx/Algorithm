package boj;

import java.util.*;

public class Main2309 {
    public static void main(String[] args) throws Exception {
        Scanner io = new Scanner(System.in);

        int sum = 0;
        int array[] = new int[9];
        int temp;


        for (int i = 0; i < 9; i++) {
            array[i] = io.nextInt();
            sum += array[i];
        }

        for(int i = 0 ; i < 8 ; i++){
            for(int j = i + 1; j < 9 ; j++){
                if(array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - array[i] - array[j] == 100) {
                    array[i] = -1;
                    array[j] = -1;
                    break;
                }
            }
            if(array[i] == -1)
                break;
        }


        for(int i = 0 ; i < 9 ; i++){
            if(array[i] != -1){
                System.out.println(array[i]);
            }
        }


        io.close();
    }
}