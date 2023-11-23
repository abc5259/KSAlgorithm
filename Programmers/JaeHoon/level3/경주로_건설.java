package Programmers.JaeHoon.level3;

import java.util.*;

public class 경주로_건설 {

    class Solution {
        int[] dx = {0, 1, 0, -1}; //상 우 하 좌
        int[] dy = {1, 0, -1, 0};
        int[][] cost;
        int N;
        int answer = Integer.MAX_VALUE- 100000;
        int[][] cBoard;
        boolean[][] isVisited;
        public int solution(int[][] board) {
            N = board.length;
            cBoard = board;
            cost = new int[N][N];
            for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE-100000);

            isVisited = new boolean[N][N];
            isVisited[0][0] = true;
            dfs(0,0,0,0);

            for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);

            dfs(0,0,1,0);

            return answer;
        }
        // dir: 0 상 1 우 2 하 3 좌
        public void dfs(int x, int y, int dir, int totalCost) {
            if(cost[x][y]< totalCost) return;
            cost[x][y] = totalCost;


            if(x == N-1 && y == N-1) {
                answer = Math.min(answer, totalCost);
                return;
            }

            for(int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || isVisited[nextX][nextY]) continue;
                if(cBoard[nextX][nextY] == 1) continue;

                int addCost = 0;
                if(i == dir) addCost = 100;
                else addCost = 600;

                isVisited[nextX][nextY] = true;
                dfs(nextX, nextY, i, totalCost + addCost);
                isVisited[nextX][nextY] = false;
            }
        }
    }
}
