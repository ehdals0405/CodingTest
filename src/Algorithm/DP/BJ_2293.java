package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    동전1
    골드 5
 */
public class BJ_2293 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*
                0   1   2   3   4   5   6   7   8   9   10
           1    1   1   1   1   1   1   1   1   1   1   1
           2    1   1   2   2   3   3   4   4   5   5   6
           5    1   1   2   2   3   4   4   5   7   8   10


         */
        int[] coin = new int[N];
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;

        /*
         누적합 구하기
         dp 배열은 현재 사용하는 동전값보다 클 때만 변동
         이전 가짓수 + (현재 금액 - 현재 동전값)의 가짓수를 더하면 현재 금액의 가짓수
         */
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= coin[i])
                    dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[K]);
    }
}
