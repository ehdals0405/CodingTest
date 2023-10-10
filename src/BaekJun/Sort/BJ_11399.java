package BaekJun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11399 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] sort = new int[1001];

        // Counting Sort 배열 생성
        for (int i = 0; i < N; i++) {
            sort[Integer.parseInt(st.nextToken())]++;
        }

        int preSum = 0;
        int totalSum = 0;

        for (int i = 0; i < 1001; i++) {

            while (sort[i]-- > 0 ){

                totalSum += preSum + i;
                preSum += i;

            }

        }

        System.out.println(totalSum);

    }
}
