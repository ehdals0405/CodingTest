package Algorithm.Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PCCE9 {

    public static void main(String[] args) {
        PCCE9 pcce9 = new PCCE9();

        int result = pcce9.solution(new String[][]{{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}}, 1, 1);
        System.out.println(result);
    }

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int row; // 가로
    static int col; // 세로

    static String color;
    static String[][] board;
    static boolean[][] visited;


    public int solution(String[][] board, int h, int w) {

        this.row = board[0].length;
        this.col = board.length;
        this.board = board;
        this.color = board[h][w];
        this.visited = new boolean[col][row];
        int result = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (color == board[i][j] && !visited[i][j]) {
                    result = bfs(i, j);
                }
            }
        }
        return result;
    }

    private int bfs(int col, int row) {

        Queue<int[]> queue = new LinkedList<>();
        visited[col][row] = true;
        queue.offer(new int[]{row, col});

        int colorCount = 0;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {

                int moveX = current[0] + dx[i];
                int moveY = current[1] + dy[i];

                if (check(moveX, moveY)) {
                    queue.offer(new int[]{moveX, moveY});
                    visited[moveY][moveX] = true;
                    colorCount++;
                }
            }
        }
        return colorCount;

    }

    private boolean check(int x, int y) {

        if (x >= 0 && x < row && y >= 0 && y < col && !visited[y][x] && color == board[y][x]) return true;

        return false;
    }
}
