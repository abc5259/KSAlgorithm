package Programmers.JaeHoon.level2;

import java.util.*;

public class 거리두기_확인하기 {

    class Solution {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        boolean[][] isVisited;
        int N;
        public List<Integer> solution(String[][] places) {
            List<Integer> answer = new ArrayList<>();
            N = places[0].length;



            for(int i=0; i<places.length; i++) {
                boolean isOk = true;
                for(int j=0; j<N; j++) {
                    for(int l=0; l<5; l++) {
                        if(!isOk) break;
                        if(places[i][j].charAt(l) == 'P') {
                            isVisited = new boolean[N][N];
                            isOk = bfs(j, l, places[i]);
                        }
                    }
                }
                answer.add(isOk ? 1 : 0);
            }
            return answer;
        }

        public boolean bfs(int x, int y, String[] places) {
            Queue<int[]> q = new LinkedList<>();
            isVisited[x][y] = true;
            q.offer(new int[]{x,y,0});

            while(!q.isEmpty()) {
                int[] curr = q.poll();
                for(int i=0; i<4; i++) {
                    int nextX = curr[0] + dx[i];
                    int nextY = curr[1] + dy[i];
                    int nextCnt = curr[2] + 1;
                    if(nextX < 0 || nextX >=N || nextY < 0 || nextY >=N || isVisited[nextX][nextY]) continue;
                    if(places[nextX].charAt(nextY) == 'X') continue;

                    if(places[nextX].charAt(nextY) == 'P') {
                        if(nextCnt <= 2) return false;
                    }

                    isVisited[nextX][nextY] = true;
                    q.offer(new int[]{nextX, nextY, nextCnt});
                }
            }

            return true;
        }
    }
}
