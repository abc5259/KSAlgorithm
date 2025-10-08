package Programmers.JaeHoon.level2;

import java.util.*;

public class 도넛과_막대_그래프 {

    class Solution {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited;
        int N;
        public int[] solution(int[][] edges) {
            int[] answer = new int[4];
            int max = 0;
            Set<Integer> set = new HashSet<>();
            for(int[] edge: edges) {
                max = Math.max(Math.max(edge[0], edge[1]), max);
                set.add(edge[1]);
            }
            N = max;
            visited = new boolean[N+1];
            for(int i=0; i<=max; i++) graph.add(new ArrayList<>());
            for(int[] edge: edges) {
                graph.get(edge[0]).add(edge[1]);
            }
            int start = -1;
            for(int i=1; i<=max; i++) {
                if(graph.get(i).size() >= 2 && !set.contains(i)) {
                    start = i;
                    break;
                }
            }
            answer[0] = start;
            for(int s: graph.get(start)) {
                visited[s] = true;
                int index = solve(s);
                // System.out.println("s = " + s + " index = " + index);
                answer[index]++;
            }
            return answer;
        }

        public int solve(int curr) {
            if(graph.get(curr).size() >= 2) return 3;
            for(int next: graph.get(curr)) {
                if(visited[next]) {
                    boolean no = false;
                    for(int nn: graph.get(next)) {
                        if(visited[nn]) continue;
                        no = true;
                    }
                    if(no) {
                        return 3;
                    }
                    return 1;
                }
                visited[next] = true;
                return solve(next);
            }

            return 2;
        }
    }
}
