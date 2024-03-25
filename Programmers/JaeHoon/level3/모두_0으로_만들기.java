package Programmers.JaeHoon.level3;

import java.util.*;

public class 모두_0으로_만들기 {

    class Solution {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited;
        long[] array;

        private long[] dfs(int node) {
            long val = 0;
            long cnt = 0;
            for (int i = 0; i < adj.get(node).size(); i ++) {
                int child = adj.get(node).get(i);
                if (!visited[child]) {
                    visited[child] = true;
                    long[] rtn = dfs(child);
                    val += rtn[0];
                    cnt += rtn[1];
                }
            }
            return new long[]{array[node]+val, cnt+Math.abs(array[node]+val)};
        }

        public long solution(int[] a, int[][] edges) {
            for (int i = 0; i < a.length; i ++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int[] edge: edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            array = new long[a.length];
            for (int i = 0; i < a.length; i ++) {
                array[i] = (long) a[i];
            }
            visited = new boolean[a.length];
            visited[0] = true;

            long[] rtn = dfs(0);
            if (rtn[0] != 0)
                return -1;
            return rtn[1];
        }
    }

}
