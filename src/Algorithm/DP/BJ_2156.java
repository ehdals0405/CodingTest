package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    포도주 시식
    실버 1
 */
public class BJ_2156 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N+1];
        int[] dp = new int[N+1];


        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        /*
           와인이 3잔일 때 마시는 경우의 수
           OXO 0 X
           OOX 0 0
           XO0 X 0
           dp[1] = wines[1]
           dp[2] = wines[1] + wines[2]
           dp[3] = Math.max(dp[2], wines[1] + wines[3] , wines[2] + wines[3])
           dp[4] = Math.max(dp[3], Math.max(dp[2] + wines[4], dp[1] + wines[3] + wines[4])

           dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wines[i], dp[i-3] + wines[i-1]+wines[i] ))
         */

        // 1잔 일땐 바로 값 리턴
        if (N == 1) {
            System.out.println(wines[1]);
            return;
        }

        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
        }

        System.out.println(dp[N]);
    }
}
