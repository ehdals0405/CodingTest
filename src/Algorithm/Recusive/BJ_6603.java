package Algorithm.Recusive;

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

        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < k; i++) {
            visited[i] = true;
            selectNum(i + 1, depth + 1);
            visited[i] = false;
        }

    }
}
