package Programmers.Hyeon.lv2;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new int[]{70, 50, 80, 50}, 100);

        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            int cnt = 0;

            Arrays.sort(people);
            int i = 0;
            int j = people.length - 1;

            while (i <= j) {
                if (people[j] + people[i] <= limit) {
                    i++;
                }
                j--;
                cnt++;
            }
            return cnt;
        }
    }
}
// lv2 구명보트 그리디문제
// 무게를 실어갈 때 최소의 보트를 사용한다.
// 가장 무거운 사람과 가벼운 사람을 태우고 이를 반복해서 간다.