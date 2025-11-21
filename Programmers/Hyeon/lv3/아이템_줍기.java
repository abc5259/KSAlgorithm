package Programmers.Hyeon.lv3;

import java.util.*;

public class 아이템_줍기 {

    class Solution {
        int[][] dist;
        final int LIMIT = 101;

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

            dist = new int[LIMIT][LIMIT];

            for (int[] r : rectangle) {
                int x1 = r[0] * 2;
                int y1 = r[1] * 2;

                int x2 = r[2] * 2;
                int y2 = r[3] * 2;

                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        if (dist[x][y] != -2) {
                            dist[x][y] = -1;
                        }
                    }
                }
                for (int x = x1 + 1; x < x2; x++) {
                    for (int y = y1 + 1; y < y2; y++) {
                        dist[x][y] = -2;
                    }
                }
            }

            bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
            return dist[itemX * 2][itemY * 2] / 2;
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        void bfs(int chx, int chy, int ix, int iy) {
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{chx, chy});
            dist[chx][chy] = 0;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();

                int cx = poll[0];
                int cy = poll[1];

                if (cx == ix && cy == iy) {
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx < 0 || ny < 0 || nx >= LIMIT || ny >= LIMIT || dist[nx][ny] != -1) {
                        continue;
                    }
                    queue.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[cx][cy] + 1;
                }
            }
        }
    }
}
// lv3 아이템_줍기 BFS
// 1시간
// 아이디어가 미쳤다 일단
// 안 이어져있음에도 불구하고 바로 옆 좌표로 이동할 수 있는 그래프 특성상 차별화를 가지기 위해
// * 2배 해서 큰 그리드를 사용한다
// ex ) 1,1 1,2 와 1,3 1,4 의 사각형이 있는데 그러면 1,2랑 1,3은 별개의 사각형이지만 바로 옆좌표에
// 사각형이 있기때문에 그래프가 움직일 수 있다
// 그래서 2,2 2,4 와 2,6 2,8로 바꾸어서 2,4와 2,6 사이에 2,5로 떨어진 사각형을 구분한다는점이다
// 이를 반영하고 또 dist 배열에 있어서 일단
// 사각형의 둘레의 좌표만 사용할 때는 전체 사각형 크기에 있어서 반복문을 사용하고
// 내부의 좌표를 반복문 돌려서 내부꺼만 파내면된다
// 근데 우리는 겹쳐져있는 공간에 있어서 외곽 좌표만 필요하기 때문에 내가 외곽좌표를 -1로 설정하고 사각형의 바깥 공간은 0으로 두고
// 내부를 -2로 설정할 건데 어떤 사각형의 내부가 어떤 사각형의 둘레가 될 수 있는데
// 이때는 내부이기 때문에 둘레는 필요없어서 이미 -2라면 -1로 초기화를 시키지 않게 조건을 설정해서 dist 라는 배열을 그렸다
// 그래서 -1이 둘레이기 때문에 -1이 아니면 continue 이고 0부터 시작해서 플러드필 한다.
// 최단거리 이기에 BFS 를 썼다 사이클 형식의 브루트포스 문제라서
// N이 50이지만 DFS 로도 충분히 가능할 거 같았다 왜냐하면 2갈래 길만 있으니까 그런데 최단거리라서 BFS가 먼저 도착하는거가 답인 반면에
// DFS 는 두개를 비교해야됐기 때문에 안했다.