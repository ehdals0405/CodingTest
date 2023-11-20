package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
   미로 탐색
   실버 1
 */
public class BJ_2178 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(graph[N - 1][M - 1]);

    }

    static void bfs() {

        Queue<Location> queue = new LinkedList<>();

        queue.add(new Location(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            Location location = queue.poll();
            int row = location.x;
            int col = location.y;

            for (int i = 0; i < 4; i++) {
                int x = row + moveX[i];
                int y = col + moveY[i];

                if (checkPath(x, y)) {

                    // 새로운 위치를 큐에 넣고 방문처리, 이전 위치에 + 1 해서 거리 갱신
                    queue.add(new Location(x,y));
                    visited[y][x] = true;
                    graph[y][x] = graph[col][row] + 1;

                }

            }
        }
    }

    static boolean checkPath(int x, int y) {

        // x,y 가 음수거나 배열을 넘어가면 false
        if (x < 0 || y < 0 || x >= M || y >= N) return false;
        // 지나갈수 없는 구역이거나 이미 지나간 구역이어도 false
        if( graph[y][x] == 0 || visited[y][x] == true) return false;

        return true;
    }
}

class Location {
    int x;
    int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

