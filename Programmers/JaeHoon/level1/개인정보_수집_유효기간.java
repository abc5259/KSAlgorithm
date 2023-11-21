package Programmers.JaeHoon.level1;
import java.util.*;

public class 개인정보_수집_유효기간 {

    class Solution {
        int[] todayArr;
        public List<Integer> solution(String today, String[] terms, String[] privacies) {
            todayArr = toIntArr(today);

            Map<String,Integer> termMap = new HashMap<>();
            for(String term: terms) {
                String[] arr = term.split(" ");
                termMap.put(arr[0], Integer.parseInt(arr[1]));
            }

            List<Integer> answer = new ArrayList<>();
            int index = 1;
            for(String privacy: privacies) {
                String[] privacyArr = privacy.split(" ");
                int[] privacyDay = toIntArr(privacyArr[0]);
                int addMonth = termMap.get(privacyArr[1]);

                privacyDay[1] += addMonth;
                if(privacyDay[1] > 12) {
                    int addYear = privacyDay[1] / 12;
                    privacyDay[1] %= 12;
                    privacyDay[0] += addYear;
                }
                if(privacyDay[1] == 0) {
                    privacyDay[1] = 12;
                    privacyDay[0] -=1;
                }
                privacyDay[2] -= 1;
                if(privacyDay[2] == 0) {
                    privacyDay[2] = 28;
                    privacyDay[1] -= 1;
                    if(privacyDay[1] == 0) {
                        privacyDay[1] = 12;
                        privacyDay[0] -= 1;
                    }
                }


                if(isBefore(privacyDay)) {
                    answer.add(index);
                }
                index++;
            }
            Collections.sort(answer);
            return answer;
        }
        public boolean isBefore(int[] day) {
            if(day[0] < todayArr[0]) return true;
            else if(day[0] == todayArr[0]) {
                if(day[1] < todayArr[1]) return true;
                else if(day[1] == todayArr[1]) {
                    if(day[2] < todayArr[2]) return true;
                    return false;
                }
                return false;
            }

            return false;

        }

        public int[] toIntArr(String day) {
            String[] daySplit = day.split("\\.");
            int[] result = new int[daySplit.length];
            for(int i=0; i<daySplit.length; i++) {
                result[i] = Integer.parseInt(daySplit[i]);
            }
            return result;
        }
    }
}
