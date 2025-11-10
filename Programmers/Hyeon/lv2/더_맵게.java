package Programmers.Hyeon.lv2;

import java.util.PriorityQueue;

public class 더_맵게 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int s : scoville) {
                pq.offer(s);
            }

            int tmp1 = 0;
            while (!pq.isEmpty()) {
                tmp1 = pq.poll();

                if (tmp1 < K) {
                    if (!pq.isEmpty()) {
                        int tmp2 = pq.poll();

                        int mix = tmp1 + tmp2 * 2;
                        answer++;

                        pq.offer(mix);
                    }
                } else {
                    break;
                }
            }
            return tmp1 < K ? -1 : answer;
        }
    }
}
// lv2 더 맵게 우선순위 큐
// 9분
// 그냥 힙 쓰는게 당연했다 왜냐하면 스코빌을 계산하는 식이 가장 작은거 2개에 대한 연산인데
// 2개를 섞어서 다시 넣어서도 정렬이 되어야 하기에
// PriorityQueue를 통해서 pq 에 넣을 때 마다 정렬이 되어서 가장 작은거 2개가 연산이 되어야 하고
// 문제 조건에서 모든 원소가 스코빌 지수 K를 못넘길경우 -1을 출력하라고 했는데 그래서
// tmp1 이라는 스코빌이 가장 최종으로 남았을 때 이가 K 보다 작으면 -1을 리턴하게 하고
// 또 while 문 반복 시 1개라도 K 를 넘길 경우 그뒤는 다 K 이상이기에 탈출을 한다