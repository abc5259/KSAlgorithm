package Programmers.JaeHoon.level3;

import java.util.*;
public class 블록_이동하기 {

    class Solution {
        int N;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int[][] rotate1 = {
                {0,0,-1,-1,-1,1},
                {0,0,1,-1,1,1},
                {-1,1,0,0,-1,0},
                {1,1,0,0,1,0}};
        int[][] rotate2 = {
                {0,0,-1,-1,1,-1},
                {0,0,-1,1,1,1},
                {1,-1,0,0,0,-1},
                {1,1,0,0,0,1}};
        public int solution(int[][] board) {
            int answer = 0;
            N = board.length;

            answer = bfs(board);

            return answer;
        }

        public int bfs(int[][] board) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0,0,0,1,0});
            boolean[][][][] isVisited = new boolean[N][N][N][N];
            isVisited[0][0][0][1] = true;

            while(!q.isEmpty()) {
                int[] curr = q.poll();

                if((curr[0] == N-1 && curr[1] == N-1) || (curr[2] == N-1 && curr[3] == N-1)) {
                    return curr[4];
                }

                for(int i=0; i<4; i++) {
                    int nx1 = curr[0] + dx[i];
                    int ny1 = curr[1] + dy[i];
                    int nx2 = curr[2] + dx[i];
                    int ny2 = curr[3] + dy[i];

                    if(nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= N) continue;
                    if(nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= N) continue;
                    if(isVisited[nx1][ny1][nx2][ny2]) continue;
                    if(board[nx1][ny1] == 1 || board[nx2][ny2] == 1) continue;

                    isVisited[nx1][ny1][nx2][ny2] = true;
                    q.offer(new int[]{nx1, ny1, nx2, ny2, curr[4] + 1});
                }

                if(curr[0] == curr[2]) { //가로

                    for(int i=0; i<4; i++) {
                        int nx1 = curr[0] + rotate1[i][0];
                        int ny1 = curr[1] + rotate1[i][1];
                        int nx2 = curr[2] + rotate1[i][2];
                        int ny2 = curr[3] + rotate1[i][3];
                        int blockX = curr[0] + rotate1[i][4];
                        int blockY = curr[1] + rotate1[i][5];

                        if(nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= N) continue;
                        if(nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= N) continue;
                        if(board[nx1][ny1] == 1 || board[nx2][ny2] == 1) continue;
                        if(board[blockX][blockY] == 1) continue;

                        int[] next = null;
                        if(nx1 < nx2) {
                            next = new int[]{nx1,ny1,nx2,ny2};
                        }else {
                            next = new int[]{nx2,ny2,nx1,ny1};
                        }
                        if(isVisited[next[0]][next[1]][next[2]][next[3]]) continue;

                        isVisited[next[0]][next[1]][next[2]][next[3]] = true;
                        q.offer(new int[]{next[0], next[1], next[2], next[3], curr[4] + 1});
                    }

                }else {//세로

                    for(int i=0; i<4; i++) {
                        int nx1 = curr[0] + rotate2[i][0];
                        int ny1 = curr[1] + rotate2[i][1];
                        int nx2 = curr[2] + rotate2[i][2];
                        int ny2 = curr[3] + rotate2[i][3];
                        int blockX = curr[0] + rotate2[i][4];
                        int blockY = curr[1] + rotate2[i][5];

                        if(nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= N) continue;
                        if(nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= N) continue;
                        if(board[nx1][ny1] == 1 || board[nx2][ny2] == 1) continue;
                        if(board[blockX][blockY] == 1) continue;

                        int[] next = null;
                        if(ny1 < ny2) {
                            next = new int[]{nx1,ny1,nx2,ny2};
                        }else {
                            next = new int[]{nx2,ny2,nx1,ny1};
                        }
                        if(isVisited[next[0]][next[1]][next[2]][next[3]]) continue;

                        isVisited[next[0]][next[1]][next[2]][next[3]] = true;
                        q.offer(new int[]{next[0], next[1], next[2], next[3], curr[4] + 1});
                    }

                }
            }
            return -1;
        }
    }
}
