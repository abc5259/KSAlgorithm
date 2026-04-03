package Programmers.Hyeon.lv3;

import java.util.*;

public class 가장_먼_노드 {
    class Solution {
        List<Integer>[] adj;
        int[] dist;

        public int solution(int n, int[][] edge) {
            adj = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int[] row : edge) {
                int y = row[0];
                int x = row[1];

                adj[y].add(x);
                adj[x].add(y);
            }
            dist = new int[n + 1];
            Arrays.fill(dist, -1);
            bfs();

            int max = 0;
            int cnt = 0;
            for (int i : dist) {
                if (max < i) {
                    max = i;
                    cnt = 1;
                } else if (max == i) {
                    cnt++;
                }
            }
            return cnt;
        }

        private void bfs() {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(1);
            dist[1] = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : adj[cur]) {
                    if (dist[next] != -1) {
                        continue;
                    }
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
// lv3 가장 먼 노드 BFS
// 10분
// n 이 2만 정점이 5만개다.
// 그냥 BFS 로 푸는데 바로 되던데.. 이거 bfs 돌려서 dist 얻은 다음에
// 가장 먼 거리에 있는지 max 로 비교하면서 값 구해가면됨..
// max랑 현재 값의 같으면 cnt 개수만 늘리고 아니면 cnt를 1로 초기화시키고 그러면된다.