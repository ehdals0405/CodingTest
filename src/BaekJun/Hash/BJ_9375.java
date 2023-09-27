package BaekJun.Hash;

import java.util.HashMap;
import java.util.Scanner;

public class BJ_9375 {
    public static void main(String[] args) {

        // 테스트 케이스 n번
        // 해빈이가 가진 의상 m개
        // Map Key 값에 의상 종류 Value 에 의상 개수

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        while (n-- > 0) {

            int m = sc.nextInt();
            HashMap<String, Integer> wears = new HashMap<>();

            for (int j = 0; j < m; j++) {
                // 의상 종류와 개수를 map에 넣기
                // 의상 이름은 필요 없음
                sc.next();
                String wear = sc.next();

                // 같은 의상 종류가 있으면 1 추가하기 없으면 새로 추가
                if (wears.containsKey(wear)) {
                    wears.put(wear, wears.get(wear) + 1);
                } else {
                    wears.put(wear, 1);
                }
            }

            int styleCount = 1;

            // 있는 의상에서 조합해서 입음
            for (int num : wears.values()) {
                // 의상을 안입는 경우가 있으니까 의상 개수에 + 1
                // -> 모자가 2개 상의가 1개면 모자1 상의/ 모자2 상의/ 모자1/모자2/상의/안입음 총 6종류
                styleCount *= (num + 1);

            }
            // 의상을 모두 안입는 경우의 수 1개를 제외
            System.out.println(styleCount - 1);
        }
    }
}
