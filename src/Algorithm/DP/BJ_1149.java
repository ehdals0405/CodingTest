package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    RGB 거리
    실버 1
 */
public class BJ_1149 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];
        /*
            red = 0
            blue = 1
            green = 2
         */
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        // 3가지 경우의 수로 나누고 현재 색과 다른 이전 색 중 비용이 싼 색을 더한다.
        for (int i = 1; i < N; i++) {
            // ex) 빨강을 칠했으면 이전 집은 초록 또는 파란색을 칠해야하는데 더 작은 비용의 색을 칠한다.
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
        }

        // 가장 작은 값을 출력
        int minCost = Math.min(Math.min(cost[N - 1][0], cost[N - 1][1]), cost[N - 1][2]);
        System.out.println(minCost);
    }
}
