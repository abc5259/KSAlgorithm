package Programmers.JaeHoon.level3;

import java.util.*;
public class 등대 {

    class Solution {
        List<List<Integer>> graph = new ArrayList<>();
        int[][] dp;
        boolean[] isVisited;
        int answer;
        public int solution(int n, int[][] lighthouse) {
            dp = new int[n+1][2];
            isVisited = new boolean[n+1];
            for(int i=0; i<=n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<lighthouse.length; i++) {
                int v1 = lighthouse[i][0];
                int v2 = lighthouse[i][1];
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }


            dfs(1);

            return Math.min(dp[1][0], dp[1][1]);
        }

        public void dfs(int n) {

            isVisited[n] = true;

            List<Integer> childs = new ArrayList<>();
            for(int next: graph.get(n)) {
                if(isVisited[next]) continue;
                childs.add(next);
                dfs(next);
            }

            dp[n][0] = 0;
            dp[n][1] = 1;

            for(int next: childs) {
                dp[n][0] += dp[next][1];
                dp[n][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}
