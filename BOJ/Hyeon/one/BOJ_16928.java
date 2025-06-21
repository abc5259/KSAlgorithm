package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    static int N, M;
    static int[][] game;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        game = new int[10][10];
        visit = new boolean[10][10];

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());
            game[u / 10][u % 10] = v;
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        visit[0][0] = true;
        queue.offer(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            if (x == 9 && y == 9) {
                return poll.cnt;
            }
            for (int i = 1; i <= 6; i++) {
                int nx = poll.x + i;
                int ny = poll.y;
                if (nx > 9) {
                    nx -= 10;
                    ny++;
                }

                if (ny > 9 || ny < 0 || visit[ny][nx]) {
                    continue;
                }
                if (game[ny][nx] == 0) {
                    visit[ny][nx] = true;
                    queue.offer(new Node(ny, nx, poll.cnt + 1));
                } else {
                    int tmp = game[ny][nx] - 1;
                    if (!visit[tmp / 10][tmp % 10]) {
                        visit[tmp / 10][tmp % 10] = true;
                        queue.offer(new Node(tmp / 10, tmp % 10, poll.cnt + 1));
                    }
                }
            }
        }
        return 0;
    }

    static class Node {
        private final int y;
        private final int x;
        private final int cnt;

        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}

// G5 뱀과 사다리 게임 BFS
// 바로 풀었다 접근 자체를 쉽게 했다