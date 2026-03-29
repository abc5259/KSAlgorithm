package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ_2665_1 {
    static int n;
    static boolean[][] wall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        wall = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == '0') {
                    wall[i][j] = true;
                }
            }
        }

        System.out.println(dijkstra());
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int dijkstra() {
        Deque<Node> queue = new ArrayDeque<>();
        int[][] cnt = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cnt[i], Integer.MAX_VALUE);
        }

        queue.offer(new Node(0, 0, 0));
        cnt[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int cy = cur.y;
            int cx = cur.x;

            if (cy == n - 1 && cx == n - 1) {
                return cur.w;
            }

            if (cnt[cy][cx] < cur.w) {
                continue;
            }


            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if (wall[ny][nx]) {
                    if (cnt[ny][nx] > cur.w + 1) {
                        cnt[ny][nx] = cur.w + 1;
                        queue.addLast(new Node(ny, nx, cnt[ny][nx]));
                    }
                } else {
                    if (cnt[ny][nx] > cur.w) {
                        cnt[ny][nx] = cur.w;
                        queue.addFirst(new Node(ny, nx, cur.w));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int y;
        int x;
        int w;

        Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.w = cnt;
        }
    }
}
// 미로만들기 G4 0-1 BFS
// 개선된 풀이.
// 벽을 깨냐 안깨냐 밖에 없어서 그냥 0-1 BFS 로 풀었다.