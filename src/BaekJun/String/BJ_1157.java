package BaekJun.String;

import java.util.Scanner;

public class BJ_1157 {
    public static void main(String[] args) {
        // 문자열을 입력받기
        // 문자열을 전부 대문자로 바꿔서 대소문자 구분 없애기
        // 알파벳 나온 횟수를 나타내는 배열 만들고 순회해서
        // 알파벳이 나오면 count++ 해주기?
        // 제일 큰 인덱스 값을 출력
        // 배열의 요소 값이 전부 같으면 ? 출력
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        words = words.toUpperCase();

        int[] counts = new int[26];

        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                counts[c - 'A']++;
            }
        }
        int Max = 0;
        char MaxChar = 0;
        boolean sameIndex = false;

        for (int i = 0; i < counts.length; i++) {
            if (Max < counts[i]) {
                Max = counts[i];
                MaxChar = (char) (i + 'A');
                sameIndex = false;
            }else if(Max == counts[i]){ // 가장 큰숫자와 같은 인덱스값이 있으면 ? 반환
                sameIndex =true;
            }
        }
        if(sameIndex){
            System.out.println('?'); 
        } else System.out.println(MaxChar);
    }
}