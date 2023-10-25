package Algorithm.Recusive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630 {

    static int withe = 0;
    static int blue = 0;

    static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        // 그래프 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, N);

        sb.append(withe + "\n").append(blue);
        System.out.println(sb);
    }

    static void partition(int row, int col, int size) {

        // 만약 주변에 색이 다 같으면
        if (colorCheck(row, col, size)) {
            // 종이 카운트 1개 증가
            if (graph[row][col] == 0) {
                withe++;
            } else {
                blue++;
            }
            return;
        }

        // 주변색이 다른게 있으면 종이 반으로 나눠서 다시 탐색
        int newSize = size / 2;

        // 각각 사분면으로 나눠서 색깔 확인
        partition(row, col + newSize, newSize); // 1 사분면
        partition(row, col, newSize); // 2 사분면
        partition(row + newSize, col, newSize); // 3 사분면
        partition(row + newSize, col + newSize, newSize); // 4 사분면

    }

    static boolean colorCheck(int row, int col, int size) {

        // 해당 사분면 주변 색이 다르면 false 리턴하고 종이를 4분면으로 나누기 반복
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (graph[row][col] != graph[i][j]) {

                    return false;
                }
            }
        }
        // 해당 사분면이 모두 같은 색이면 true 반환
        return true;
    }

}
