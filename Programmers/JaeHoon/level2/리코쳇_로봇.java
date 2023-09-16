package Programmers.JaeHoon.level2;

import java.util.*;

public class 리코쳇_로봇 {

    class Solution {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        boolean[][] isVisited;
        int N,M;
        public int solution(String[] board) {
            int answer = 0;
            N = board.length;
            M = board[0].length();
            isVisited = new boolean[N][M];
            Loop: for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(board[i].charAt(j) == 'R') {
                        answer = bfs(new int[]{i,j},board);
                        break Loop;
                    }
                }
            }
            return answer;
        }
        public int bfs(int[] start,String[] board) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{start[0],start[1],0});
            isVisited[start[0]][start[1]] = true;

            while(!q.isEmpty()) {
                int[] curr = q.poll();

                for(int i=0; i<4; i++) {
                    int x = curr[0];
                    int y = curr[1];

                    while(true) {
                        if(x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M && board[x + dx[i]].charAt(y + dy[i]) != 'D') {
                            x += dx[i];
                            y += dy[i];
                        }else {
                            if(!isVisited[x][y]) {
                                if(board[x].charAt(y) == 'G') return curr[2] + 1;
                                isVisited[x][y] = true;
                                q.offer(new int[]{x,y,curr[2] + 1});
                            }
                            break;
                        }
                    }

                }
            }
            return -1;
        }
    }
}
