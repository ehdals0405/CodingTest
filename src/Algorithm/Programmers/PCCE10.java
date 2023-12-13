package Algorithm.Programmers;

import java.util.*;

public class PCCE10 {

    public static void main(String[] args) {
        PCCE10 pcce10 = new PCCE10();
        int[][] result = pcce10.solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}},"date",20300501,"remain");
        System.out.println(Arrays.deepToString(result));
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // data를 ext가 val_ext보다 작은 값만 뽑아내서 sort_by로 정렬

        // 인덱스 값을 찾기 위한 맵
        Map<String, Integer> map = new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);

        // 추출할 값 인덱스
        int extDataIndex = map.get(ext);

        // 추출할 값을 넣을 리스트
        List list = new ArrayList();

        // val_ext 이하의 값만 넣기
        for (int[] d: data) {
            if(val_ext > d[extDataIndex]){
                list.add(d);
            }
        }
        // 정렬할 인덱스 값
        int sortIndex = map.get(sort_by);
        // 인덱스 기준으로 오름차순으로 변경
        Collections.sort(list, Comparator.comparingInt((int[] o) -> o[sortIndex]));

        // 배열로 변환
        int[][] result = (int[][]) list.toArray(new int[0][]);

        return  result;
    }
}
