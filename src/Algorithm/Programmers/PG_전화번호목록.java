package Algorithm.Programmers;

import Algorithm.Hash.PG_완주하지못한사람;

import java.util.HashSet;

public class PG_전화번호목록 {

    public static void main(String[] args) {

        PG_전화번호목록 pg_전화번호목록 = new PG_전화번호목록();

        System.out.println(pg_전화번호목록.solution(	new String[]{"123", "456", "789"}));

    }

    public boolean solution(String[] phone_book) {


        HashSet<String> set = new HashSet<>();

        for (String num: phone_book) {
            set.add(num);
        }

        for (String num : set) {
            for (int i = 1; i < num.length(); i++) {
                String s = num.substring(0,i);
                if(set.contains(s)) return false;
            }
        }
        return true;
    }

}
