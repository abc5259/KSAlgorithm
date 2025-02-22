package Programmers.Hyeon.lv1;

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
            int employee = schedules.length;

            for (int i = 0; i < employee; i++) {
                int hour = (schedules[i] / 100) * 60 + (schedules[i] % 100) + 10;

                int cnt = 0;
                for (int j = 0; j < 7; j++) {
                    int day = (startday + j - 1) % 7;
                    int th = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);
                    if (day != 5 && day != 6 && hour >= th) {
                        cnt++;
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

// Lv1 유연근무제 20205 프로그래머스 코드챌린지
// 일단 그냥 시간계산하는거랑 조건 분기에만 신경쓰면된다
