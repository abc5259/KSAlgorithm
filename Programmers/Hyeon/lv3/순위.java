package Programmers.Hyeon.lv3;

import java.util.*;

public class 순위 {

    class Solution {
        List<Integer>[] winner;
        List<Integer>[] loser;
        boolean[] visit;

        public int solution(int n, int[][] results) {

            winner = new ArrayList[n + 1];
            loser = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                winner[i] = new ArrayList<>();
                loser[i] = new ArrayList<>();
            }

            for (int[] row : results) {
                int A = row[0];
                int B = row[1];

                winner[A].add(B);
                loser[B].add(A);
            }

            visit = new boolean[n + 1];

            int player = 0;
            for (int i = 1; i <= n; i++) {
                Arrays.fill(visit, false);

                if (bfs(i, winner) + bfs(i, loser) == n - 1) {
                    player++;
                }
            }

            return player;
        }

        private int bfs(int start, List<Integer>[] adj) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            visit[start] = true;

            int cnt = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : adj[cur]) {
                    if (visit[next]) {
                        continue;
                    }
                    visit[next] = true;
                    queue.offer(next);
                    cnt++;
                }
            }

            return cnt;
        }
    }
}

// lv3 순위 BFS
// 7분
// 풀이법을 기억해내서.. 풀었다. 그냥 커넥티드 컴포넌트를 구하는거에 다가 adj 정방향 역방향으로 구분해서
// 두개의 노드수의 합이 본인 제외한 과 같다면 player 를 늘려서 리턴한다.
