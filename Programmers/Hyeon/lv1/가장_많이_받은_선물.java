package Programmers.Hyeon.lv1;

import java.util.HashMap;

public class 가장_많이_받은_선물 {
    class Solution {
        public int solution(String[] friends, String[] gifts) {

            int len = friends.length;

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < len; i++) {
                map.put(friends[i], i);
            }

            int[][] gT = new int[len][len];
            int[] present = new int[len];

            for (String s : gifts) {
                String[] str = s.split(" ");

                int giver = map.get(str[0]);
                int taker = map.get(str[1]);

                gT[giver][taker]++;

                present[giver]++;
                present[taker]--;
            }

            int[] res = new int[len];

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {

                    if (i == j) {
                        continue;
                    }
                    if (gT[i][j] > gT[j][i]) {
                        res[i]++;
                    } else if (gT[i][j] == gT[j][i]) {
                        if (present[i] > present[j]) {
                            res[i]++;
                        }
                    }
                }
            }

            int answer = 0;

            for (int v : res) {
                answer = Math.max(answer, v);
            }

            return answer;
        }
    }
}
// lv1 2024 KAKAO WINTER INTERNSHIP 가장 많이 받은 선물 문자열
// 40분
// 계속 [i][j] 를 [j][j] 로 하고 못 찾고있었다. 디버깅이 어려움.
// HashMap 으로 O(1)로 이름을 인덱스화 시키게 자료구조 사용하고 나서
// gifts 배열을 돌면서 준사람의 인덱스 받은 사람 인덱스에 ++ 해서 주고 받음의 선물을 gT배열에 저장하고
// 준사람에게는 present 선물지수 배열에 ++ 를 받은 사람은 -- 해서 구한다.
// 그리고 두사람 간의 선물 기록을 비교해서 만약 내가 더 줬으면 res에 +하고 또 같다면 내 선물지수가 더 클때만 + 해서 결과 가짐.