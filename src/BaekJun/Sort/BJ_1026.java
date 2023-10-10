package BaekJun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1026 {
    public static void main(String[] args) throws IOException {

        // 정렬해서 A 맨앞 B 맨뒤 곱한거 더하기?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // A 배열
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // B 배열
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;

        for (int i = 0; i < N; i++) {

            int multi = A[i] * B[N-1-i];
            sum += multi;

        }
        System.out.println(sum);
    }
}
