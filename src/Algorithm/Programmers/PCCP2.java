package Algorithm.Programmers;

import java.util.*;

public class PCCP2 {
    public static void main(String[] args) {

        PCCP2 pccp2 = new PCCP2();
        int result = pccp2.solution(new int[][] {{0, 0, 0, 1, 1, 1, 0, 0},{0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
        System.out.println(result);
    }

    // BFS로 석유 크기를 재고 key value로 저장해두고 m까지 열을 탐색하면서 석유가 있는 지형을 만나면
    // 해당 지형의 key 값을 저장 후 모든 key 값으로 value를 찾아서 더해주기

    static int n, m; // 세로 가로
    static int[] dx = new int[]{1, -1, 0, 0}; // x 축 움직이기
    static int[] dy = new int[]{0, 0, 1, -1}; // y 축 움직이기

    static int[][] land;

    static boolean[][] visited; // 방문 여부 배열
    static int[][] oil; // 오일 위치를 key로 나타낼 배열

    public int solution(int[][] land) {
        this.land = land;
        this.n = land.length;
        this.m = land[0].length;
        this.visited = new boolean[n][m];
        this.oil = new int[n][m];

        Map<Integer, Integer> oilSize = new HashMap<>();// 석유 사이즈와 id 값을 담을 맵

        int oilId = 0;

        // 석유 사이즈를 재서 맵에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j, oilId);
                    oilSize.put(oilId, size);
                    oilId++;
                }
            }

        }
        int[] oilSum = new int[m]; // 각 열의 석유 총합을 저장할 배열

        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (land[j][i] == 1){
                    set.add(oil[j][i]);
                }
            }
            // set에 저장된 석유 id 사이즈 만큼을 더하여 총합 배열에 저장
            for (int id: set) {
                oilSum[i] += oilSize.get(id);
            }

        }

        // 가장 큰값출력
        return Arrays.stream(oilSum).max().getAsInt();
    }

    private int bfs(int x, int y, int oilId) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        oil[x][y] = oilId;
        int oilSize = 1;


        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {

                int moveX = current[0] + dx[i];
                int moveY = current[1] + dy[i];

                if (check(moveX, moveY)) {
                    queue.offer(new int[]{moveX, moveY});
                    visited[moveX][moveY] = true;
                    oil[moveX][moveY] = oilId;
                    oilSize++;

                }

            }

        }
        return oilSize;
    }

    // 석유 체크
    private boolean check(int x, int y) {

        if (x >= 0 && x < n && y >= 0 && y < m && land[x][y] == 1 && !visited[x][y]) {
            return true;
        }
        return false;
    }
}

