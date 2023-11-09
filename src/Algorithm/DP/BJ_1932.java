package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    정수 삼각형
    실버 1
 */
public class BJ_1932 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // N모양 정사각형 배열 생성
        int[][] triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
            7
            3 8
            8 1 0
            1. Max? 3 + 8 or 1 / 8 + 1 or 0
            2. Max? 11 + 7 / 9 + 7
            ... triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1])
         */

        for (int i = N - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }
        // 꼭대기 계산값 출력
        System.out.println(triangle[0][0]);
    }
}
