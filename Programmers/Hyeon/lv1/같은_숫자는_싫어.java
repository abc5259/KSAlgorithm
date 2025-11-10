package Programmers.Hyeon.lv1;

import java.util.ArrayDeque;

public class 같은_숫자는_싫어 {
    public class Solution {
        public int[] solution(int[] arr) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for (int num : arr) {
                if (!queue.isEmpty() && queue.peekLast() == num) {
                    continue;
                }
                queue.offer(num);
            }
            int[] answer = new int[queue.size()];

            int i = 0;

            while (!queue.isEmpty()) {
                answer[i++] = queue.poll();
            }

            return answer;
        }
    }
}
// lv1 같은 숫자는 싫어 스택, 큐
// 8분
// 그냥 풀었다
// deque를 써서 queue로 풀었다 peekLast 가 중요했다
// peek 은 맨 앞을 가리키기에 차라리 Last 를 안쓰면 stack 의 peek 을 썼어야 했다.