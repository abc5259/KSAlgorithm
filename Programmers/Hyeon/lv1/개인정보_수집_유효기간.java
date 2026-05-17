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
