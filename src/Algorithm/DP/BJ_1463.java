package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기
// 실버 3
public class BJ_1463 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 숫자 최소 연산 수를 담을 배열
        int[] dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i < N + 1; i++) {

            // 이전 연산 수에서 + 1 하면 다음 수 최소 연산 수 ex) 4면 이전값은 3인데 4 - 1 = 3 이기 때문
            dp[i] = dp[i - 1] + 1;
            // 2 또는 3 으로 나눠지면 나눠진 숫자의 최수 연산수 + 1 과 이전 최소 연산수 비교
            // ex) 8일 경우 8 / 2 = 4 -> 4의 최소 연산수에서 2 한번 더 나눈거라 2 + 1 = 3
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[N]);

        br.close();

    }
}
