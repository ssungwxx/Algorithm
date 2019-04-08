package boj;

import java.util.*;

public class Main14500 {
    public static void main(String[] args) throws Exception {
        Scanner io = new Scanner(System.in);

        int sum = 0;
        int temp;

        int N = io.nextInt();
        int M = io.nextInt();
        int array[][] = new int[500][500];

        if(4 <= N && N <= 500 && 4 <= M && M <= 500 && N < 1001 && M < 1001){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0; j < M; j++){
                    array[i][j] = io.nextInt();
                }
            }
        }

        if(4 <= N && N <= 500 && 4 <= M && M <= 500 && N < 1001 && M < 1001){
            for(int i = 0 ; i < N ; i++){
                for(int j=0; j < M ; j++){
                    if(i+3 < N){
                        temp = array[i][j] + array[i+1][j] +  array[i+2][j] + array[i+3][j];
                        if (sum < temp) sum = temp;
                    }
                    if(j < M-3){
                        temp = array[i][j] + array[i][j+1] +  array[i][j+2] + array[i][j+3];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-2){
                        temp = array[i][j] + array[i+1][j] +  array[i][j+1] + array[i+1][j+1];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-1 && j < M-2){
                        temp = array[i][j] + array[i][j+1] +  array[i][j+2] + array[i+1][j];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-1){
                        temp = array[i][j] + array[i+1][j] +  array[i+2][j] + array[i+2][j+1];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-1 && j < M-2){
                        temp = array[i+1][j] + array[i+1][j+1] +  array[i+1][j+2] + array[i][j+2];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-1){
                        temp = array[i][j] + array[i][j+1] +  array[i+1][j+1] + array[i+2][j+1];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-1){
                        temp = array[i][j+1] + array[i+1][j+1] +  array[i+2][j+1] + array[i+2][j];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-1){
                        temp = array[i][j] + array[i][j+1] +  array[i+1][j] + array[i+2][j];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-1 && j < M-2){
                        temp = array[i][j] + array[i][j+1] +  array[i][j+2] + array[i+1][j+2];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-1){
                        temp = array[i][j] + array[i+1][j] +  array[i+1][j+1] + array[i+2][j+1];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-1 && j < M-2){
                        temp = array[i][j] + array[i+1][j] +  array[i+1][j+1] + array[i+1][j+2];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-1){
                        temp = array[i][j+1] + array[i+1][j] +  array[i+1][j+1] + array[i+2][j];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-1 && j < M-2){
                        temp = array[i+1][j] + array[i+1][j+1] +  array[i][j+1] + array[i][j+2];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-1){
                        temp = array[i][j] + array[i][j+1] +  array[i+1][j+1] + array[i+1][j+2];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-1){
                        temp = array[i][j] + array[i+1][j] +  array[i+2][j] + array[i+1][j+1];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-1 && j < M-2){
                        temp = array[i][j+1] + array[i+1][j] +  array[i+1][j+1] + array[i+1][j+2];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-2 && j < M-1){
                        temp = array[i+1][j] + array[i][j+1] +  array[i+1][j+1] + array[i+2][j+1];
                        if (sum < temp) sum = temp;
                    }
                    if(i < N-1 && j < M-2){
                        temp = array[i][j] + array[i][j+1] +  array[i][j+2] + array[i+1][j+1];
                        if (sum < temp) sum = temp;
                    }
                }
            }
        }

        System.out.println(sum);

        io.close();
    }
}