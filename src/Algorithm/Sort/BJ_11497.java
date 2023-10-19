package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11497 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 인접한 통나무 사이 길이 최대값 찾기
        // 원형이기 때문에 선형 구조로 하면 안되고 최대 값을 비교하기 위해
        // 양쪽으로 통나무 배치

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int logNum = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            // 통나무 넣을 배열
            int[] logs = new int[logNum];

            // 통나무 리스트에 넣고 정렬
            for (int j = 0; j < logNum; j++) {
                logs[j] = Integer.valueOf(st.nextToken());
            }
            Arrays.sort(logs);

            // 정렬 후 양쪽으로 하나씩 배치해주기
            int left = 0;
            int right = logNum - 1;
            int result = 0;

            int[] array = new int[logNum];

            for (int j = 0; j < logNum; j++) {
            // 정렬된 통나무를 배열 양쪽으로 하나씩 넣어줌
                if (j % 2 == 0) array[left++] = logs[j];
                else array[right--] = logs[j];
            }
            // 인접한 것 끼리 비교
            for (int j = 1; j < logNum; j++) {
                result = Math.max(result, Math.abs(array[j] - array[j - 1]));
            }
            // 처음과 마지막에 인접한 것도 비교
            result = Math.max(result, Math.abs(array[0] - array[logNum - 1]));
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
