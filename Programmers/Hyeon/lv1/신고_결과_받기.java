package Programmers.Hyeon.lv1;

import java.util.*;

public class 신고_결과_받기 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {

            int len = id_list.length;

            // report 중복 제거
            Set<String> set = new HashSet<>();

            for (String s : report) {
                set.add(s);
            }

            // 이름으로 인덱스 하는 방법.
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.put(id_list[i], i);
            }

            // 신고 한 사람 이 인덱스고 그 사람이 신고한 ID 들.
            List<String>[] list = new ArrayList[len];

            for (int i = 0; i < len; i++) {
                list[i] = new ArrayList<>();
            }

            // 이게 정지된 ID 의 카운트 횟수 frodo 면 2인거지.
            int[] cnt = new int[len];

            for (String s : set) {
                String[] arr = s.split(" ");

                list[map.get(arr[0])].add(arr[1]);
                int report_id = map.get(arr[1]);

                cnt[report_id]++;
            }

            int[] res = new int[len];

            // 각 이름이 가지는 애들 중
            for (int i = 0; i < len; i++) {
                for (String name : list[i]) {
                    int idx = map.get(name);
                    if (cnt[idx] >= k) {
                        res[i]++;
                    }
                }
            }

            return res;
        }
    }
}
// lv1 2022 KAKAO BLIND RECRUITMENT 신고 결과 받기 문자열 Map Set
// 22분
// 일단 문자열로 인덱싱 하는 방법을 이해했다.
// Map 을 구성해서 idx 를 value 로 가진채로 하고 다른 곳에서 문자열로 인덱스를 찾을 때
// O(1) 로 map.get(문자열)로 idx 를 반환해서 쓸 수 있다.
// 그리고 report가 중복이 되는거 같아서 Set 처리해두고 report 이제 안쓰고
// 인접 리스트를 만들어서 신고한 사람을 인덱스로 두고 그 인덱스의 list 에 신고당한 애들의 이름을 적는다
// 그리고 cnt 배열로 신고당한 애들의 횟수를 기록해서
// 이제 인접 리스트의 name 에서 cnt[idx] 즉 신고 횟수가 k 보다 크거나 같을 경우 res 라는 배열로 리턴해준다.