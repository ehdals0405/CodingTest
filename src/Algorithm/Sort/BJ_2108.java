package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        // 숫자 배열
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        // 정렬
        Arrays.sort(array);

        // 최빈 값 구하기
        int[] countingSort = new int[8001];
        ArrayList<Integer> mode = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            // 계수 정렬
            // 4000 보다 크면 양수 작으면 음수
            countingSort[array[i] + 4000]++;
            // 얼마나 등장했는지 최대치를 카운팅
            max = Math.max(countingSort[array[i] + 4000], max);
        }
        for (int i = 0; i < 8001; i++) {
            // 등장 수와 같으면 최빈값으로 넣어주기
            // 2개 이상 안넣어도 됌
            if(countingSort[i] == max) {
                mode.add(i - 4000);
                if(mode.size() == 2) break;
            }
        }

        // 최빈값은 mode 의 첫번째 또는 두번째 값


        // 산술 평균
        double sum = Arrays.stream(array).sum();
        int a = (int) Math.round(sum / N);
        sb.append(a + "\n");
        // 중앙 값
        int b = array[N/2];
        sb.append(b + "\n");
        // 최빈 값
        int c;
        if(mode.size() > 1) c = mode.get(1);
        else c = mode.get(0);
        sb.append(c + "\n");
        // 범위
        int d = array[N-1] - array[0];
        sb.append(d + "\n");

        System.out.println(sb);
    }
}
