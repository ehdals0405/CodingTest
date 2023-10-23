package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(array);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        // 이분 탐색으로 찾기
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N - 1;

            int result = binarySearch(left, right, num, array);

            if (result == 1) sb.append(1 + " ");
            else sb.append(0 + " ");

        }
        System.out.println(sb);
    }

    static int binarySearch(int left, int right, int num, int[] array) {

        while (left <= right) {

            int media = (left + right) / 2;

            if (array[media] == num) {
                return 1;
            } else if (array[media] > num) {
                right = media - 1;
            } else {
                left = media + 1;
            }
        }
        return -1;
    }
}
