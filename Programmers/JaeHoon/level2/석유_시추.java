package Programmers.JaeHoon.level2;

import java.util.*;

public class 석유_시추 {

    class Solution {
        List<Set<Integer>> results = new ArrayList<>();
        int N,M;
        boolean[][] isVisited;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        public int solution(int[][] land) {
            int answer = 0;
            N = land.length;
            M = land[0].length;
            isVisited = new boolean[N][M];

            for(int i=0; i<M; i++) {
                results.add(new HashSet<>());
            }

            Map<Integer,Integer> map = new HashMap<>();
            int num = 1;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(isVisited[i][j]) continue;
                    if(land[i][j] == 1) {
                        int cnt = bfs(i,j,num,land);
                        map.put(num, cnt);
                        num++;
                    }
                }
            }

            for(int i=0; i<M; i++) {
                int sum = 0;
                for(Integer n : results.get(i)) {
                    sum += map.get(n);
                }
                answer = Math.max(answer,sum);
            }
            return answer;
        }

        public int bfs(int x, int y, int num, int[][] land) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x,y});
            isVisited[x][y] = true;
            int cnt = 1;
            while(!q.isEmpty()) {
                int[] curr = q.poll();
                results.get(curr[1]).add(num);

                for(int i=0; i<4; i++) {
                    int nextX = curr[0] + dx[i];
                    int nextY = curr[1] + dy[i];
                    if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || isVisited[nextX][nextY]) continue;
                    if(land[nextX][nextY] == 0) continue;
                    q.offer(new int[]{nextX, nextY});
                    isVisited[nextX][nextY] = true;
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
