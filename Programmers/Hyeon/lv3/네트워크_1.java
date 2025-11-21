package Programmers.Hyeon.lv3;

import java.util.ArrayDeque;

public class 네트워크_1 {

    class Solution {
        int n;
        boolean[] visit;
        int[][] computers;

        public int solution(int n, int[][] computers) {
            visit = new boolean[n];
            this.computers = computers;
            this.n = n;

            int answer = 0;

            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    answer++;
                    bfs(i);
                }
            }
            return answer;
        }

        void bfs(int num) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.offer(num);
            visit[num] = true;

            while (!queue.isEmpty()) {
                int poll = queue.poll();

                for (int i = 0; i < n; i++) {
                    if (computers[poll][i] != 1 || visit[i]) {
                        continue;
                    }
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
// lv3 네트워크 BFS
// 5분
// 전체 탐색하는 거니 섬의 개수 처럼 풀었더니 문제 없이 잘됐다 쉬운 문제