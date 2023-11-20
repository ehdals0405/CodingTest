package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    바이러스
    실버 3
 */
public class BJ_2606 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[N + 1][N + 1];

        // 그래프 만들기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        boolean[] visited = new boolean[N + 1];

        System.out.println(bfs(graph, visited));

    }

    // bfs
    public static int bfs(int[][] graph, boolean[] visited) {

        Queue<Integer> queue = new LinkedList();
        int virus = 0;

        queue.add(1);
        visited[1] = true;

        while (queue.size() != 0) {

            int next = queue.poll();

            for (int j = 1; j < graph.length; j++) {
                if (graph[next][j] == 1 && !visited[j]) {
                    queue.add(j);
                    virus++;
                    visited[j] = true;
                }
            }
        }
        return virus;
    }
}
