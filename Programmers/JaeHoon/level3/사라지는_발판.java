package Programmers.JaeHoon.level3;

public class 사라지는_발판 {

    class Solution {
        int[][] map;
        int N,M;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int cAnswer = 0;
        public int solution(int[][] board, int[] aloc, int[] bloc) {
            int answer = -1;
            map = board;
            N = map.length;
            M = map[0].length;
            return dfs(aloc[0],aloc[1],bloc[0],bloc[1]);
        }

        public int dfs(int ax, int ay, int bx, int by) {
            if(map[ax][ay] == 0) return 0;
            int ret = 0;

            map[ax][ay] = 0;
            for(int i=0; i<4; i++) {
                int nextX = ax + dx[i];
                int nextY = ay + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(map[nextX][nextY] == 0) continue;

                int val = dfs(bx, by, nextX, nextY) + 1;

                if(ret % 2 == 0 && val % 2 == 1) ret = val;
                else if(ret % 2 == 0 && val % 2 == 0) ret = Math.max(ret,val);
                else if(ret % 2 == 1 && val % 2 == 1) ret = Math.min(ret,val);
            }
            map[ax][ay] = 1;
            return ret;
        }
    }
}
