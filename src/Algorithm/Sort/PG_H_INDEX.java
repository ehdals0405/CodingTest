package Algorithm.Sort;

import java.util.*;

public class PG_H_INDEX {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{0,1,2,5,6}));
    }

    public static int solution(int[] citations) {

        Arrays.sort(citations);
        int answer = 0;
        // 정렬하면 i = 0 일 때 citations[0] 만큼 인용한 논문이 length - 0 개
        // i = 1 일때 citations[1] 만큼 인용한 논문이 length - 1 개
        // i = 2 일때 citations[2] 만큼 인용한 논문이 length - 2 개
        // i = 3 일때 citations[3] 만큼 인용한 논문이 length - 3 개
        // ...
        for (int i = 0; i < citations.length; i++) {

            int hIndex = citations.length - i;

            // 인용한 논문 수가 남은 논문 수 보다 클 때를 찾기
            // 뒤로 갈 수록 hIndex 값이 작아지므로 찾았으면 더 찾을 필요가 없음
            if(citations[i] >= hIndex){
                answer = hIndex;
                break;
            }

        }

        return answer;
    }
}
