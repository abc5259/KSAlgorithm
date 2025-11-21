package Programmers.Hyeon.lv2;

import java.util.ArrayDeque;

public class 게임_맵_최단거리 {

    class Solution {
        int N, M;
        int[][] maps;
        int[][] dist;

        public int solution(int[][] maps) {
            this.maps = maps;
            N = maps.length;
            M = maps[0].length;

            dist = new int[N][M];

            bfs();

            return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        void bfs() {
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0, 0});
            dist[0][0] = 1;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();

                int cy = poll[0];
                int cx = poll[1];

                for (int i = 0; i < 4; i++) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || dist[ny][nx] != 0) {
                        continue;
                    }
                    if (maps[ny][nx] == 1) {
                        queue.offer(new int[]{ny, nx});
                        dist[ny][nx] = dist[cy][cx] + 1;
                    }
                }
            }
        }
    }
}
// lv2 게임 맵 최단거리 BFS
// 16분
// 자꾸 무슨 에러가 발생해서 봤더니 시작 좌표는 0,0 이 고정이고 만약 N-1 , M-1 로 도달을 못하면
// -1 을 리턴한다
// 일단 무조건 중요한게 문제를 잘읽어야 한다
// 전반적인 BFS 기초문제