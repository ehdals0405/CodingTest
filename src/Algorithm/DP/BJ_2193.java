package Algorithm.DP;

import java.util.Scanner;

/*
    이친수
    실버 3
 */
public class BJ_2193 {

    public static void main(String[] args) {


    /*
        N= 1 1  - 1
        N= 2 10 - 1
        N= 3 100 101 - 2
        N= 4 1000 1001 1010 - 3
        N= 5 10000 10001 10101 10100 10010 - 5
        N= 6 100000 100001 101010 100101 101001 101000 100100 100010 - 8

        N[i] = N[i-1] + N[i-2]
     */
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] dp = new long[N + 1]; // 40대로 넘어가면 int 최대값을 넘어서 long으로 해야함..

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < N+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);

    }
}
