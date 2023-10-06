package BaekJun.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_26043 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 좋아하는 메뉴 먹은 학생 목록
        List<String> A = new LinkedList<>();
        // 식사만 한 학생 목록
        List<String> B = new LinkedList<>();
        // 못먹은 학생 목록
        List<String> C = new LinkedList<>();


        Queue<Student> students = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        // 반복 횟수
        while (N-- > 0) {

            st = new StringTokenizer(br.readLine(), " ");
            // 유형 1 또는 2 확인
            int type = Integer.parseInt(st.nextToken());
            // 1 유형은 학생이므로 학생 정보를 넣고 queue에 넣어줌
            if (type == 1) {
                String num = st.nextToken();
                String favorite = st.nextToken();
                students.add(new Student(num, favorite));
            } else {
                // 2 유형은 메뉴 정보를 queue에 넣어줌
                String menu = st.nextToken();
                Student student = students.poll();
                if (student.favorite.equals(menu)) {

                    A.add(student.num);
                } else B.add(student.num);

            }
        }
        // 남은 학생들은 C 목록에 넣어줌
        while (!students.isEmpty()) {
            C.add(students.poll().num);
        }
        // 정렬
        Collections.sort(A);
        Collections.sort(B);
        Collections.sort(C);

        // 출력
        print(A);
        print(B);
        print(C);


    }

    static void print(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("None");
        } else {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    // 학생 정보
    static class Student {

        Student(String num, String favorite) {
            this.num = num;
            this.favorite = favorite;
        }

        String num;
        String favorite;
    }
}

