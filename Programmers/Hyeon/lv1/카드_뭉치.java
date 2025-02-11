package Programmers.Hyeon.lv1;

import java.util.ArrayDeque;

public class 카드_뭉치 {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        Solution solution = new Solution();
        String res = solution.solution(cards1, cards2, goal);
        System.out.println(res);
    }

    static class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            ArrayDeque<String> q1 = new ArrayDeque<>();
            for (String s : cards1) {
                q1.offer(s);
            }
            ArrayDeque<String> q2 = new ArrayDeque<>();
            for (String s : cards2) {
                q2.offer(s);
            }

            for (String s : goal) {
                if (!q1.isEmpty() && s.equals(q1.peek())) {
                    q1.poll();
                } else if (!q2.isEmpty() && s.equals(q2.peek())) {
                    q2.poll();
                } else {
                    return "No";
                }
            }
            return "Yes";
        }
    }
}
// lv1 카드 뭉치 큐 문제
// 쉽게 풀었다 조건문을 처음부터 잘 만들어야 한다. 그냥 일치하면 poll 안 일치한채로 반복할 경우 return 해주면된다.