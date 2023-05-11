package baekJun.string;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1259 {
    public static void main(String[] args) {
        // 문자열 입력받기
        // 문자열을 배열로받고 배열을 뒤집은거랑 그냥 배열과 같으면 yes..?


        Scanner sc = new Scanner(System.in);
        while (true) {
            int nums = sc.nextInt();
            sc.nextLine();
            if (nums == 0) {
                break;
            }

            String words = String.valueOf(nums);
            String[] arrs = words.split("");
            String[] reverse = reverseArr(arrs);
            if (Arrays.equals(arrs, reverse)) {
                System.out.println("yes");
            } else System.out.println("no");

        }
    }

    public static String[] reverseArr(String[] arr) { // 재귀함수 한번 써먹어보자
        if (arr.length == 0) { // base case
            return new String[]{};
        }
        //recursive case
        String[] head = Arrays.copyOfRange(arr, arr.length - 1, arr.length);
        String[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length - 1));
        String[] dest = new String[head.length + tail.length];

        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);

        return dest;
    }
}
