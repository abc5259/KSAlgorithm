package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, List<String>> girlGroup = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String group = br.readLine();

            int members = Integer.parseInt(br.readLine());

            List<String> girl = new ArrayList<>();
            for (int j = 0; j < members; j++) {

                String name = br.readLine();
                girl.add(name);
            }

            Collections.sort(girl);

            girlGroup.put(group, girl);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int com = Integer.parseInt(br.readLine());

            if (com == 1) {
                for (String key : girlGroup.keySet()) {
                    if (girlGroup.get(key).contains(name)) {
                        sb.append(key).append("\n");
                        break;
                    }
                }
            } else {
                if (girlGroup.containsKey(name)) {
                    for (int s = 0; s < girlGroup.get(name).size(); s++) {
                        sb.append(girlGroup.get(name).get(s)).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
// S3 걸그룹 마스터 준석이 HashMap
// 19분
// 걸그룹 이름(Key)과 멤버들 이름(Value)을 관리하고 검색해야 함
// 자료구조 선택 HashMap + ArrayList 그룹 이름으로 멤버를 찾을 때 O(1)로 빠르게 조회하기 위해 Map을 선택
// Map의 Key는 유니크하므로 그룹명을 Key로 설정
// 한 그룹에 멤버가 여러 명이고 사전순 정렬으로 Value는 List<String>으로 설정하고 정렬함
// 1 : Key를 모르는 상태이므로 Map의 keySet()을 순회하며 리스트에 이름이 포함되었는지 확인 후 그룹명 반환
// 0 : 그룹명만 가지고 Map.get()으로 리스트를 O(1)로 가져와서 출력