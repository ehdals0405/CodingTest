package baekJun.string;

import java.util.Scanner;

public class BJ_1264 {
    public static void main(String[] args) {
        // 1.문자열을 입력 받기
        // 2.모음이 들어간 문자 배열
        // 3.문자열을 순회하면서 문자가 일치하면 카운트++

        Scanner sc = new Scanner(System.in);
        int count;
        String word;
        char[] alphabets = {'a', 'e', 'i', 'o', 'u' };
        while (true) {
            word = sc.nextLine().toLowerCase();
            if (word.equals("#")) {
                break;
            }
            count = 0;
            for (char ch : word.toCharArray()) {
                for (char alphabet : alphabets) {
                    if (ch == alphabet) {
                        count++;
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
