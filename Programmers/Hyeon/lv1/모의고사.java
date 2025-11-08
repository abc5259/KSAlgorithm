package Programmers.Hyeon.lv1;

import java.util.ArrayList;

public class 모의고사 {
    class Solution {
        public int[] solution(int[] answers) {
            int[][] MathGiveUpers = {
                    {1, 2, 3, 4, 5},
                    {2, 1, 2, 3, 2, 4, 2, 5},
                    {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
            };

            int[] scores = new int[3];

            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == MathGiveUpers[0][i % 5]) {
                    scores[0]++;
                }
                if (answers[i] == MathGiveUpers[1][i % 8]) {
                    scores[1]++;
                }
                if (answers[i] == MathGiveUpers[2][i % 10]) {
                    scores[2]++;
                }
            }

            int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                if (scores[i] == maxScore) {
                    list.add(i + 1);
                }
            }
            int[] answer = new int[list.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
// lv1 모의고사 완전탐색
// 20분
// 프로그래머스 적응 중
// 코테 환경에서의 Solution 클래스의 매개변수 입력값 적응
// 그냥 3명의 값을 입력받을 때 mod 연산을 통해서 값을 비교해서 증가하고 2차원 배열로 입력값을 다루면서
// 그리고 answer 라는 정답 배열을 리턴하기 위해 ArrayList 로 값을 옮겨서 연산한다.
