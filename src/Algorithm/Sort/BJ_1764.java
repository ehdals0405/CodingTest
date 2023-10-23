package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 2번 나오면 출력 -> 맵 value 가 2면 출력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }


        int count = 0;

        for (String name : map.keySet()) {
            if(map.get(name) == 2){
                count++;
                sb.append(name + "\n");
            }
        }
        System.out.println(count + "\n" + sb );
    }
}
