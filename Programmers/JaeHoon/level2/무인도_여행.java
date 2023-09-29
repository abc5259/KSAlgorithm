package Programmers.JaeHoon.level2;

import java.util.*;
public class 무인도_여행 {

    class Solution {
        boolean[][] isVisited;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int N,M;
        String[] map;
        public ArrayList<Integer> solution(String[] maps) {
            ArrayList<Integer> island = new ArrayList<>();
            int[] answer = {};
            map = maps;
            N = maps.length;
            M = maps[0].length();
            isVisited = new boolean[N][M];
            for(int i=0; i < N; i++) {
                for(int j=0; j< M; j++) {
                    if(isVisited[i][j]) continue;
                    if(maps[i].charAt(j) == 'X') continue;
                    island.add(bfs(i,j));

                }
            }

            Collections.sort(island);
            if(island.size() == 0) island.add(-1);
            return island;
        }
        public int bfs(int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x,y});
            isVisited[x][y] = true;
            int sum = map[x].charAt(y) - '0';
            while(!q.isEmpty()) {
                int[] curr = q.poll();

                for(int i=0; i<4; i++) {
                    int nextX = curr[0] + dx[i];
                    int nextY = curr[1] + dy[i];

                    if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || isVisited[nextX][nextY]) continue;
                    if(map[nextX].charAt(nextY) == 'X') continue;
                    sum += (map[nextX].charAt(nextY) - '0');
                    q.offer(new int[]{nextX,nextY});
                    isVisited[nextX][nextY] = true;
                }
            }

            return sum;
        }
    }
}
