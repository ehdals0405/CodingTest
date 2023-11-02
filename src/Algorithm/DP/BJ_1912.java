package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속합
// 실버 2
public class BJ_1912 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[0] = array[0];
        int max = array[0];

        for (int i = 1; i < N; i++) {
            // 이전 숫자 + 지금 숫자와 지금 숫자를 비교하고 큰 것을 저장
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);

            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
