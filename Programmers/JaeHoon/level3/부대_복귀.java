package Programmers.JaeHoon.level3;

import java.util.*;
public class 부대_복귀 {

    class Solution {
        List<List<Integer>> graph = new ArrayList<>();
        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer = new int[sources.length];

            for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

            for(int i=0; i<roads.length; i++) {
                graph.get(roads[i][0]).add(roads[i][1]);
                graph.get(roads[i][1]).add(roads[i][0]);
            }

            int[] cost = bfs(destination, n);
            for(int i=0; i<sources.length; i++) {
                answer[i] = cost[sources[i]] == Integer.MAX_VALUE ? -1 : cost[sources[i]];
            }

            return answer;
        }

        public int[] bfs(int start, int n) {
            int[] cost = new int[n+1];
            Arrays.fill(cost, Integer.MAX_VALUE);

            cost[start] = 0;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{start,0});

            while(!q.isEmpty()) {
                int[] curr = q.poll();

                for(int next: graph.get(curr[0])) {
                    if(cost[next] == Integer.MAX_VALUE) {
                        cost[next] = curr[1] + 1;
                        q.offer(new int[]{next, cost[next]});
                    }
                }
            }

            return cost;
        }
    }
}
