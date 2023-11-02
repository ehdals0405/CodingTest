package Algorithm.Recursion;

import java.io.IOException;
import java.util.Scanner;


public class BJ_6603 {
    static int k;
    static int[] nums;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();

            // 0 이면 반복 그만
            if (k == 0) break;

            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = sc.nextInt();
            }

            result = new int[6];
            visited = new boolean[k];
            selectNum(0, 0);

            System.out.println(sb);
        }
    }

    // 숫자 6개 조합
    static void selectNum(int start, int depth) {

        // 종료 조건
        if (depth == 6) {
            for (int i : result) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        // 재귀 호출
        // 같은 숫자는 여러번 나오면 안되게 제외
        for (int i = start; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = nums[i];
                selectNum(i, depth + 1);
                visited[i] = false;
            }

        }
    }
}
