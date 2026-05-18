package Programmers.Hyeon.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 개인정보_수집_유효기간 {

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {

            int[] todays = new int[3];

            StringTokenizer st = new StringTokenizer(today, ".");

            for (int i = 0; i < 3; i++) {
                todays[i] = Integer.parseInt(st.nextToken());
            }

            HashMap<String, Integer> map = new HashMap<>();

            for (String s : terms) {
                st = new StringTokenizer(s);

                String part = st.nextToken();
                int d = Integer.parseInt(st.nextToken());
                map.put(part, d);
            }


            int len = privacies.length;

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                st = new StringTokenizer(privacies[i]);

                String d = st.nextToken();
                String p = st.nextToken();

                int plusDuration = map.get(p);

//             String[] dates = d.split(".");

//             int ye = Integer.parseInt(dates[0]);
//             int mo = Integer.parseInt(dates[1]);
//             int da = Integer.parseInt(dates[2]);

                st = new StringTokenizer(d, ".");

                int ye = Integer.parseInt(st.nextToken());
                int mo = Integer.parseInt(st.nextToken());
                int da = Integer.parseInt(st.nextToken());

                mo += plusDuration;
                ye += (mo - 1) / 12;
                mo = (mo - 1) % 12 + 1;

                if (ye < todays[0]) {
                    list.add(i + 1);
                } else if (ye == todays[0]) {
                    if (mo < todays[1]) {
                        list.add(i + 1);
                    } else if (mo == todays[1]) {
                        if (da <= todays[2]) {
                            list.add(i + 1);
                        }
                    }
                }
            }

            int[] answer = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
// lv1 2023 KAKAO BLIND RECRUITMENT 개인정보 수집 유효기간 문자열
// 40분
// 일단 풀었는데 trouble shooing 에서 오래걸림
// 먼저 가장 중요한점 프로그래머스 특성상 디버깅이 어려우니 반복문이나 로직단위로 디버깅 하면서 코드를 작성하는 습관이 필요할 듯?
// 나중에 시간초과나 컴파일 에러뜨면 안되니까.
// 1. split 메소드는 정규표현식으로 해야돼서 "." 이 아니라 "\\." 했어야함 그냥 StringTokenizer 쓰자.
// 2. month 연산 특성 같은 edge case 에 오래씀 그래서 1 + 12 / 12 하면 1년 1월 더하면되는데
// 1 + 11 개월이면 1년 0월이 됨 그래서 애초에 month 에서 -1 을 하고나서 mod 연산을 진행하고 month 에는 + 1해버리면된다
// 예시 1월 + 11개월 == > 0+11 / 12 0년, 0 + 11 % 12 == 11 + 1 == 12 12월 이런식으로.
// 동적 리스트를 정적 배열로 하려면 그냥 반복문과 size 로 다루자.