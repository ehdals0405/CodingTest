package Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780 {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(N, 0, 0);

        sb.append(minus + "\n").append(zero + "\n").append(plus);

        System.out.println(sb);
    }

    static void partition(int size, int row, int col) {
        // 종료 조건
        if (paperCheck(size, row, col)) {
            if (paper[row][col] == 1) plus++;
            else if (paper[row][col] == -1) minus++;
            else zero++;

            return;
        }
        // 재귀 호출
        // 종이가 같지 않으면 3분할로 나눠서 탐색
        int newSize = size / 3;

        // 첫번째 줄
        partition(newSize, row, col); // 왼쪽 위
        partition(newSize, row, col + newSize); // 중간 위
        partition(newSize, row, col + 2 * newSize); // 오른쪽 위

        // 두번째 줄
        partition(newSize, row + newSize, col); // 중간 왼쪽
        partition(newSize, row + newSize, col + newSize); // 중간 중앙
        partition(newSize, row + newSize, col + 2 * newSize); // 중간 오른쪽

        // 세번째 줄
        partition(newSize, row + 2 * newSize, col); // 아래 왼쪽
        partition(newSize, row + 2 * newSize, col + newSize); // 아래 중앙
        partition(newSize, row + 2 * newSize, col + 2 * newSize); // 아래 오른쪽

    }

    // 종이 종류 체크
    static boolean paperCheck(int size, int row, int col) {

        int paperColor = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paperColor != paper[i][j])
                    return false;
            }
        }
        return true;
    }
}
