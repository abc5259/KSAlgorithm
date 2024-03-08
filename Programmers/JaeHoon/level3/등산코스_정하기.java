package Programmers.JaeHoon.level3;

import java.util.*;

public class 등산코스_정하기 {

    class Solution {
        class Node {
            int v,w;
            Node(int v, int w) {
                this.v = v;
                this.w = w;
            }
        }
        List<List<Node>> graph = new ArrayList<>();
        int[] map;
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            map = new int[n+1];
            for(int i=0; i<gates.length; i++) {
                map[gates[i]] = 1; //출입구는 1
            }
            for(int i=0; i<summits.length; i++) {
                map[summits[i]] = 2; //산봉우리는 2
            }
            for(int i=0; i<=n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int[] path: paths) {
                graph.get(path[0]).add(new Node(path[1],path[2]));
                graph.get(path[1]).add(new Node(path[0],path[2]));
            }

            int[] cost = bfs(n, gates);
            int number = -1;
            int intensity = Integer.MAX_VALUE;
            for(int i=1; i<=n; i++) {
                if(map[i] == 2 && cost[i] < intensity) {
                    number = i;
                    intensity = cost[i];
                }
            }

            return new int[]{number, intensity};
        }
        public int[] bfs(int n, int[] gates) {
            int[] cost = new int[n+1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            Queue<int[]> q = new LinkedList<>();
            for(int i=0; i<gates.length; i++) {
                cost[gates[i]] = 0;
                q.offer(new int[]{gates[i], 0});
            }

            while(!q.isEmpty()) {
                int[] curr = q.poll();
                for(Node next: graph.get(curr[0])) {
                    //출발점은 가면 안됨
                    if(map[next.v] == 1) continue;

                    //산봉우리라면?
                    if(map[next.v] == 2) {
                        cost[next.v] = Math.min(Math.max(curr[1] , next.w), cost[next.v]);
                    }

                    //쉼터라면?
                    if(map[next.v] == 0) {
                        // intensity이 기존보다 작다면 ㄱㄱ
                        if(Math.max(curr[1] , next.w) < cost[next.v]) {
                            cost[next.v] = Math.min(Math.max(curr[1] , next.w), cost[next.v]);
                            q.offer(new int[]{next.v, cost[next.v]});
                        }
                    }
                }
            }
            return cost;
        }
    }
}
