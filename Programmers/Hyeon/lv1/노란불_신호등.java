package Programmers.Hyeon.lv1;

public class 노란불_신호등 {
    class Solution {
        public int solution(int[][] signals) {
            int max = 1;

            for (int[] signal : signals) {
                int cycle = signal[0] + signal[1] + signal[2];
                max = lcm(max, cycle);
            }

            for (int i = 1; i <= max; i++) {
                boolean allYellow = true;

                for (int[] signal : signals) {
                    int gr = signal[0];
                    int ye = signal[1];
                    int re = signal[2];

                    int cycle = gr + ye + re;

                    int rem = (i - 1) % cycle;

                    if (!(rem >= gr && rem < gr + ye)) {
                        allYellow = false;
                        break;
                    }
                }

                if (allYellow) {
                    return i;
                }
            }

            return -1;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int tmp = b;
                b = a % b;
                a = tmp;
            }
            return a;
        }

        private int lcm(int a, int b) {
            return a / gcd(a, b) * b;
        }
    }
}
// lv1 2025 카카오 하반기 1차 노란불 신호등 완전 탐색
// 29분
// 일단 풀었다.
// 신호등의 개수가 5개고 주기가 20이라서 최악으로 해도 20^5라 시간은 문제없었음
// 처음에 주기의 곱만큼 길이 잡아서 boolean[][] 배열에 노란불 상태 기록해서 true 시점 탐색으로 했는데
// 시간복잡도가 N * 주기 곱이 라 MOD 연산 교체
// 최소 공배수 + MOD 연산으로 타이트하게 압축한 다음 배열에 기록안하고 현재 시간 t 를 주기로 나눈 나머지를 계산해서
// 초록 || 빨강이 아닌지 해서 노란불 판별