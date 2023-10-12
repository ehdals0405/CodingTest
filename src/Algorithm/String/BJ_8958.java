package Algorithm.String;

import java.util.Scanner;

public class BJ_8958 {
    public static void main(String[] args) {
        //시행횟수 입력받기
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        // O면 count +1씩 해주고 X면 count를 0으로 만들기?
        for (int j = 0; j < num; j++) {
            int sum = 0;
            int count = 0;
            String words = sc.nextLine(); // 문자열 입력 받기
            String[] OX = words.split(""); // 문자열 배열에 넣기
            for (int i = 0; i < OX.length; i++) {
                if (OX[i].equals("O")) {
                    count++;
                    sum += count;

                } else {
                    count = 0;
                }
            }
            System.out.println(sum);
        }
    }
}

