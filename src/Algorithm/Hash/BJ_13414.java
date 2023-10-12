package Algorithm.Hash;

import java.io.*;
import java.util.*;

public class BJ_13414 {

    public static void main(String[] args) throws IOException {

        // 수강 가능 인원 K 대기 목록 L
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 학번을 담은 해시셋
        LinkedHashSet<String> apply = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
        // 학번이 중복되면 삭제하고 뒤에 넣기
            String id = br.readLine();
            if(apply.contains(id)) apply.remove(id);
            apply.add(id);
        }
        // 앞에서 부터 K 만큼 출력
        for (String id : apply) {
            while(K-- > 0){
                System.out.println(id);
                break;
            }
        }
    }
}