package Algorithm.String;

import java.util.Scanner;

public class BJ_11655 {
    public static void main(String[] args) {
        // 문자열 받기
        // 알파벳 문자를 13글자씩 밀기 -> 'c' + 13
        // 문자를 순회하면서 c 값에 13을 다 더하기
        // A~Z = 65~90 a~z = 97~122
        // 더했을 떄 90 초과 103 이하이면 26 빼기
        // 더했을 떄 122 초과 135 이하이면 26 빼기

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (words[i] >= 97 && words[i] <= 122) {
                words[i] = (char) (words[i] + 13);
                if (words[i] > 122 && words[i] <= 135) {
                    words[i] = (char) (words[i] - 26);
                }

                } else if (words[i] >= 65 && words[i] <= 90) {
                    words[i] = (char) (words[i] + 13);
                    if (words[i] > 90 && words[i] <= 103 )
                        words[i] = (char) (words[i] - 26);
                }
            }
        for (char c : words) {
            System.out.print(c);
        }
    }
}
