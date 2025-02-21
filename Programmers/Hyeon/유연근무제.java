package Programmers.Hyeon;

import java.util.ArrayDeque;

public class 유연근무제 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.solution(new int[]{700, 800, 1100}, new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}}, 5);
        System.out.println(res);
    }

    static class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;
            int len = schedules.length;
            int tmp;
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                tmp = startday;
                for (int j = 0; j < 7; j++) {
                    queue.offer(new int[]{timelogs[i][j], tmp});
                    tmp++;
                }
            }

            for (int i = 0; i < len; i++) {
                int cnt = 0;
                for (int j = 0; j < 7; j++) {
                    if (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        int day = (startday + j - 1) % 7;
                        if (day == 5 || day == 6) {
                            continue;
                        }
                        int hour = (schedules[i] / 100) * 60 + (schedules[i] % 100) + 10;
                        int th = (arr[0] / 100) * 60 + (arr[0] % 100);
                        if (hour >= th) {
                            cnt++;
                        }
                    }
                }
                if (cnt == 5) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
