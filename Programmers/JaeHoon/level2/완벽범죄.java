package Programmers.JaeHoon.level2;
import java.util.*;

public class 완벽범죄 {
  class Solution {
    boolean[][][] dp;
    int[][] info;
    int N,M;
    int n,m;
    public int solution(int[][] info, int n, int m) {
        N = info.length;
        M = info[0].length;
        this.info = info;
        this.n = n;
        this.m = m;
        dp = new boolean[N][121][121];
        
        solve(0, 0, 0);
        int result = 122;
        for(int i=0; i<=120; i++) {
            for(int j=0; j<=120; j++) {
                if(dp[N-1][i][j]) {
                    result = Math.min(result, i);
                }
            }   
        }
        return result == 122 ? -1 : result;
    }
    
    public void solve(int depth, int aSum, int bSum) {
        if(depth == N) {
            return;
        }
        if(aSum >= n || bSum >= m) {
            return;
        }
        if(dp[depth][aSum][bSum]) {
            return;
        }
    
        if(aSum + info[depth][0] < n) {
            dp[depth][aSum + info[depth][0]][bSum] = true;
            solve(depth+1, aSum + info[depth][0], bSum);    
        }
        if(bSum + info[depth][1] < m) {
            dp[depth][aSum][bSum + info[depth][1]] = true;
            solve(depth+1, aSum, bSum + info[depth][1]);
        }
    }
  }
}
