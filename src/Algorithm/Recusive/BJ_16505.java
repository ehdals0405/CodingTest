package Algorithm.Recusive;

import java.util.Scanner;

public class BJ_16505 {

    static char[][] graph;
    static int size = 0;

    static int N = 0;

    public static void main(String[] args) {

        // 규칙 : 이전 숫자의 별 3번 그리기
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();

        // 별을 3번 그리려면 1, 2x1 , 2x2 , 2x2x2 .. 2^n 개 만큼의 배열이 필요
        size = (int) Math.pow(2, N);
        graph = new char[size][size];

        // 배열 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                graph[i][j] = ' ';
            }
        }

        drawStar(0, 0, 0);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++)
                sb.append(graph[i][j]);

            if (i != size - 1)
                sb.append("\n");
        }


        System.out.println(sb);
    }

    static void drawStar(int depth, int row, int col) {

        // 종료조건
        if (depth == N) {
            graph[col][row] = '*';
            return;
        }

        int size = (int) Math.pow(2, depth);
        // 재귀호출
        drawStar(depth + 1, row, col);
        drawStar(depth + 1, row + size, col);
        drawStar(depth + 1, row, col + size);
    }
}