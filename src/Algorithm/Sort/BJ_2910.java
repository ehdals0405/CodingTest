package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2910 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());


        // 순서를 보장하는 HashMap, 등장한 숫자와 등장 횟수를 넣는다
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Map 에 있는 키값을 list 로 옮기고 등장 횟수로 정렬, 등장 횟수가 같으면 넣은 숫자 순서대로
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> Integer.compare(map.get(b), map.get(a)));

        // 등장 횟수만큼 출력
        for (int i: list) {

            for (int j = 0; j < map.get(i); j++) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }
}
