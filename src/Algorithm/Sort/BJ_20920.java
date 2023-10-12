package Algorithm.Sort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_20920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 단어 갯수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 단어 길이 기준
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordMap = new HashMap<>();

        while (N-- > 0) {
            // M 보다 긴 단어만 맵에 넣기
            String word = br.readLine();
            int frequency = wordMap.getOrDefault(word,0);
            if (word.length() >= M) wordMap.put(word, frequency + 1);
        }
        // 단어 리스트
        List<String> words = wordMap.keySet().stream().collect(Collectors.toList());
        // 정렬
        Collections.sort(words, (o1, o2) -> {

            int frequency1 = wordMap.get(o1);
            int frequency2 = wordMap.get(o2);
            // 빈도수도 같고 길이도 같으면 사전 순 정렬
            if (frequency1 == frequency2) {
                if (o1.length() == o2.length()) {

                    return o1.compareTo(o2);
                }
                // 단어 길이가 다르면 단어 길이 순으로 정렬
                return o2.length() - o1.length();
            }
            // 빈도수가 다르면 빈도수 많은 순으로 정렬
            return frequency2 - frequency1;
        });

        for (String word : words) {
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
