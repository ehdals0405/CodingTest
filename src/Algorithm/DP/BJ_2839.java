package Algorithm.DP;

import java.io.BufferedReader;
import java.util.Scanner;

/*
    설탕배달
    실버4
*/
public class BJ_2839 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        /*  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17 ...
        bag 1 -1  1  2  -1  2  3  2   3   4   3   4   3   4  5
        N/5 0  0  1  1  1  1  1  2   2   2   2   2   2   2   3
        N%5 3  4  0  1  2  3  4  0   1   2   3   4   0   1   2

        N/5 = 0 -> bag = N/5
        N = 4, 7 -> -1
        N%5 = 3 bag = N/5 +1
        N%5 = 2,4 = N/5 +2
         */

        int bag = 0;

        if (N == 4 || N == 7) bag = -1;
        else if (N % 5 == 0) bag = N / 5;
        else if (N % 5 == 1 || N % 5 == 3) bag = N / 5 + 1;
        else if (N % 5 == 2 || N % 5 == 4) bag = N / 5 + 2;

        System.out.println(bag);
    }
}
