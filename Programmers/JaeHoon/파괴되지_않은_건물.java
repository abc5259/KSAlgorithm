package Programmers.JaeHoon;

public class 파괴되지_않은_건물 {
  class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] dp = new int[N][M];
        for(int i=0; i<skill.length; i++) {
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            if(skill[i][0] == 1) degree = degree * -1;
            dp[r1][c1] += degree;
            if(r2 + 1 < N) dp[r2+1][c1] -= degree;
            if(c2 + 1 < M) dp[r1][c2+1] -= degree;
            if(c2 + 1 < M && r2 + 1 < N) dp[r2+1][c2+1] += degree;
        }
        
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<M; j++) {
                dp[i+1][j] += dp[i][j];
            }   
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M-1; j++) {
                dp[i][j+1] += dp[i][j];
            }   
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                board[i][j] += dp[i][j];
                if(board[i][j] > 0 ) answer++;
            }   
        }
        return answer;
    }
}
  
}
