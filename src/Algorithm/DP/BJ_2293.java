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

    }
}
