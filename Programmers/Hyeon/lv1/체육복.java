package Programmers.Hyeon.lv1;

import java.util.Arrays;

public class 체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            Arrays.sort(lost);
            Arrays.sort(reserve);

            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] == reserve[j]) {
                        answer++;
                        lost[i] = 0;
                        reserve[j] = 0;
                        break;
                    }
                }
            }

            for (int l : lost) {
                if (l == 0) {
                    continue;
                }
                for (int i = 0; i < reserve.length; i++) {
                    if (reserve[i] == 0) {
                        continue;
                    }

                    if (l - 1 == reserve[i] || l + 1 == reserve[i]) {
                        reserve[i] = 0;
                        answer++;
                        break;
                    }
                }
            }
            return answer + n - lost.length;
        }
    }
}
// lv1 체육복 그리디
// 30분
// trouble shooting
// 난 아무리 고민해도 몰랐었다. lost 와 reserve 를 정렬해야되는지
// 왜냐하면 당연히 정렬해서 주는 줄 알았다 테스트 케이스도 정렬되어있길래
// 그리고 도난과 여벌을 먼저 처리하고 그다음에 여벌을 나눠주는 거로 했다
// 예외처리를 통해서 했다
