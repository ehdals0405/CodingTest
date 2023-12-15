package Algorithm.Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PG_완주하지못한사람 {

    public static void main(String[] args) {

        PG_완주하지못한사람 p = new PG_완주하지못한사람();

        System.out.println(p.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));

    }

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (String name: map.keySet()) {
            if(map.get(name) > 0)
                return name;
        }

        return "";
    }
}
