package Programmers.JaeHoon.level3;

import java.util.*;
public class 숫자_타자_대회 {

    class Solution {

        int[][][] dp;
        int size;
        String numberss;
        int[][] dist = {
                { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
                { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
                { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
                { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
                { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
                { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
                { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
                { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
                { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
                { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
        };
        public int solution(String numbers) {
            dp = new int[13][13][numbers.length()];
            size = numbers.length();
            numberss = numbers;

            for(int i=0; i<=12; i++) {
                for(int j=0; j<=12; j++) {
                    Arrays.fill(dp[i][j],-1);
                }
            }
            return dfs(0,4,6);
        }

        public int dfs(int depth, int left, int right) {

            if(depth == size) {
                return 0;
            }

            if(dp[left][right][depth] != -1) return dp[left][right][depth];

            int n = numberss.charAt(depth) - '0';

            int result = Integer.MAX_VALUE;
            if(right != n) {
                result = Math.min(result, dfs(depth+1, n, right) + dist[left][n]);
            }

            if(left != n) {
                result = Math.min(result, dfs(depth+1, left, n) + dist[right][n]);
            }

            return dp[left][right][depth] = result;


        }
    }
}
