package boj;

import java.util.*;

public class Main9095 {
    public static void main(String[] args) throws Exception {
        Scanner io = new Scanner(System.in);

        int testCase = io.nextInt();
        int input;

        int count = 0;

        for (int test = 0; test < testCase; test++) {
            input = io.nextInt();

            for (int i1 = 1; i1 <= 3; i1++) {
                if(i1 == input) count++;
                for (int i2 = 1; i2 <= 3; i2++) {
                    if(i1+i2 == input) count++;
                    for (int i3 = 1; i3 <= 3; i3++) {
                        if(i1+i2+i3 == input) count++;
                        for (int i4 = 1; i4 <= 3; i4++) {
                            if(i1+i2+i3+i4 == input) count++;
                            for (int i5 = 1; i5 <= 3; i5++) {
                                if(i1+i2+i3+i4+i5 == input) count++;
                                for (int i6 = 1; i6 <= 3; i6++) {
                                    if(i1+i2+i3+i4+i5+i6 == input) count++;
                                    for (int i7 = 1; i7 <= 3; i7++) {
                                        if(i1+i2+i3+i4+i5+i6+i7 == input) count++;
                                        for (int i8 = 1; i8 <= 3; i8++) {
                                            if(i1+i2+i3+i4+i5+i6+i7+i8 == input) count++;
                                            for (int i9 = 1; i9 <= 3; i9++) {
                                                if(i1+i2+i3+i4+i5+i6+i7+i8+i9 == input) count++;
                                                for (int i10 = 1; i10 <= 3; i10++) {
                                                    if(i1+i2+i3+i4+i5+i6+i7+i8+i9+i10 == input) count++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }


        io.close();
    }
}