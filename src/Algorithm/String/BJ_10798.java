package Algorithm.String;

import java.util.Scanner;

public class BJ_10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[5];  // 다섯 개의 단어를 저장하는 배열

        // 다섯 줄에 각각의 단어 입력 받기
        for (int i = 0; i < 5; i++) {
            str[i] = sc.next();
        }

        // 열을 가만히 두고 행을 먼저 반복하기?
        for (int j = 0; j < 15; j++) { // 최대 15글자여서 15번까지 반복
            for (int i = 0; i < 5; i++) { // 5개 단어라 5번 반복
                if (j < str[i].length()) { // 단어의 길이가 j보다 작으면 출력할 문자열이 없으므로 출력 X
                    System.out.print(str[i].charAt(j)); // 모든 단어의 0,1,2...번째 문자를 출력
                }
            }
        }
    }
}