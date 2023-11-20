package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
// 실버 3
public class BJ_14501 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] day = new int[N];
        int[] fee = new int[N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            fee[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            // 상담 날짜가 퇴사일을 넘기는지 확인
            if (i + day[i] <= N) {
                // 다른 상담으로 인해 상담이 끝났을 때의 그 날의 수입과 이번 상담으로 얻을 수입을 비교
                dp[i + day[i]] = Math.max(dp[i + day[i]], dp[i] + fee[i]);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);

        br.close();
    }
}
