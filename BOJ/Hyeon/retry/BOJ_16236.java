package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16236 {
    static int N;
    static int[][] map;
    static int cy, cx;
    static int size = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cy = i;
                    cx = j;
                    map[i][j] = 0;
                }
            }
        }
        int res = 0;

        int remain = 2;
        while (true) {
            int cnt = bfs(cy, cx);
            if (cnt == 0) {
                break;
            }
            res += cnt;
            remain--;
            if (remain == 0) {
                size++;
                remain = size;
            }
        }
        System.out.println(res);
    }

    static int bfs(int y, int x) {
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y == o2.y && o1.dist == o2.dist) {
                    return o1.x - o2.x;
                } else if (o1.dist == o2.dist) {
                    return o1.y - o2.y;
                }
                return o1.dist - o2.dist;
            }
        });

        queue.offer(new Node(y, x, 0));
        visit[y][x] = true;

        int cnt = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (map[cur.y][cur.x] > 0 && map[cur.y][cur.x] < size) {
                map[cur.y][cur.x] = 0;
                cy = cur.y;
                cx = cur.x;
                cnt = cur.dist;

                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                    continue;
                if (map[ny][nx] > size)
                    continue;
                if (visit[ny][nx])
                    continue;
                visit[ny][nx] = true;
                queue.offer(new Node(ny, nx, cur.dist + 1));
            }
        }
        return 0;
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y;
        int x;
        int dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}

// G3 아기 상어 시뮬레이션
// 먹는데에 우선순위를 관리한다.
// 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러간다. 거리우선
// 먹을 수 있는 물고기가 1마리보다 많다면 가장 가까운 == y 좌표가 가까운
// 가까운 물고기가 많다면 == x 좌표가 가까운
// -> 우선순위큐를 사용해서 방문여부를 판단하고 방문했으면 