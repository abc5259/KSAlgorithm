package Programmers.JaeHoon.level2;

import java.util.*;

public class 미로_탈출 {

    class Solution {
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        public int solution(String[] maps) {
            int answer = 0;

            int[] start = new int[2];
            int[] L = new int[2];
            int[] end = new int[2];

            for(int i=0; i<maps.length; i++) {
                for(int j=0; j<maps[i].length(); j++) {
                    if(maps[i].charAt(j) == 'S') {
                        start[0] = i;
                        start[1] = j;
                    }
                    if(maps[i].charAt(j) == 'E') {
                        end[0] = i;
                        end[1] = j;
                    }
                    if(maps[i].charAt(j) == 'L') {
                        L[0] = i;
                        L[1] = j;
                    }
                }
            }

            int a = bfs(maps,start,L);

            int b = bfs(maps,L,end);

            answer = a != -1 && b != -1 ? a + b : -1;

            return answer;
        }
        public int bfs(String[] maps, int[] start, int[] end) {
            int N = maps.length;
            int M = maps[0].length();
            boolean[][] isVisited = new boolean[N][M];
            isVisited[start[0]][start[1]] = true;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{start[0],start[1],0});

            while(!q.isEmpty()) {
                int[] curr = q.poll();

                for(int i=0; i<4; i++) {
                    int nextX = curr[0] + dx[i];
                    int nextY = curr[1] + dy[i];
                    if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || isVisited[nextX][nextY]) continue;
                    if(maps[nextX].charAt(nextY) == 'X') continue;
                    if(nextX == end[0] && nextY == end[1]) return curr[2] + 1;
                    isVisited[nextX][nextY] = true;
                    q.offer(new int[]{nextX, nextY, curr[2] + 1});
                }
            }
            return -1;
        }
    }
}
