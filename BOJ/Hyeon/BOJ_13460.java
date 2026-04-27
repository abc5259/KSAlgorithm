package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {
    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int ry = 0, rx = 0, by = 0, bx = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'R') {
                    ry = i;
                    rx = j;
                } else if (map[i][j] == 'B') {
                    by = i;
                    bx = j;
                }
            }
        }

        System.out.println(bfs(ry, rx, by, bx));
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int startRy, int startRx, int startBy, int startBx) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        queue.offer(new Node(startRy, startRx, startBy, startBx, 0));
        visited[startRy][startRx][startBy][startBx] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.cnt >= 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextRy = cur.ry;
                int nextRx = cur.rx;
                int rMove = 0;

                while (map[nextRy + dy[i]][nextRx + dx[i]] != '#' && map[nextRy][nextRx] != 'O') {
                    nextRy += dy[i];
                    nextRx += dx[i];
                    rMove++;
                }

                int nextBy = cur.by;
                int nextBx = cur.bx;
                int bMove = 0;

                while (map[nextBy + dy[i]][nextBx + dx[i]] != '#' && map[nextBy][nextBx] != 'O') {
                    nextBy += dy[i];
                    nextBx += dx[i];
                    bMove++;
                }

                if (map[nextBy][nextBx] == 'O') {
                    continue;
                }

                if (map[nextRy][nextRx] == 'O') {
                    return cur.cnt + 1;
                }

                if (nextRy == nextBy && nextRx == nextBx) {
                    if (rMove > bMove) {
                        nextRy -= dy[i];
                        nextRx -= dx[i];
                    } else {
                        nextBy -= dy[i];
                        nextBx -= dx[i];
                    }
                }

                if (!visited[nextRy][nextRx][nextBy][nextBx]) {
                    visited[nextRy][nextRx][nextBy][nextBx] = true;
                    queue.offer(new Node(nextRy, nextRx, nextBy, nextBx, cur.cnt + 1));
                }
            }
        }

        return -1;
    }

    static class Node {
        int ry;
        int rx;
        int by;
        int bx;
        int cnt;

        public Node(int ry, int rx, int by, int bx, int cnt) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.cnt = cnt;
        }
    }
}
// G1 구슬 탈출 2 BFS
// 55분
// 최소 이동 횟수를 구해야 하고, 최대 10번이라 BFS
// 빨간 구슬과 파란 구슬이 동시에 움직이므로 두 구슬의 좌표를 모두 상태로 관리하는 4차원으로 방문 배열
// 벽이나 구멍 만날 때까지 해당 방향으로 끝까지 전진시키는 while 문으로 보드 움직임
// 파란 구슬이 구멍에 빠지면 무조건 실패이므로 continue 처리하여 큐에 넣지 않고 예외처리
// 두 구슬이 구멍이 아닌 일반 칸에서 겹쳤을 때 이동 거리 더 큰 구슬이 뒤늦게 굴러왔다는 뜻이므로 한 칸 뒤로 롤백시켜 충돌 해결