package BaekJun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1449 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 물 새는 곳
        int N = Integer.parseInt(st.nextToken());
        // 테이프 길이
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        // 물이 새는 곳을 나타내는 배열
        int[] array = new int[N];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        // 처음 물 새는 곳에 테이프를 붙이고 최대한 사용할 수 있는 범위
        double tapeRange = array[0] - 0.5 + L;
        // 테이프 개수
        int tape = 1;

        for (int i = 1; i < array.length; i++) {

            // 다음 물 새는 곳이 테이프 길이보다 길면 새로운 테이프 사용
            if (tapeRange < array[i] + 0.5) {
                tapeRange = array[i] - 0.5 + L;
                tape++;
            }
        }

        System.out.println(tape);

    }
}
