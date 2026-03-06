package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261 {
    static int N, M;
    static boolean[][] wall;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        wall = new boolean[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1') {
                    wall[i][j] = true;
                }
            }
        }

        System.out.println(bfs());
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.y == N - 1 && cur.x == M - 1) {
                return cur.w;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
                    continue;
                }

                if (wall[ny][nx]) {
                    pq.offer(new Node(ny, nx, cur.w + 1));
                } else {
                    pq.offer(new Node(ny, nx, cur.w));
                }
                visit[ny][nx] = true;
            }
        }
        return 0;
    }

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int w;

        public Node(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return this.w - node.w;
        }
    }
}
// G4 알고스팟 다익스트라? BFS?
// 23분
// 일단 풀었다 왜 안되지 하고 10분정도 고민했는데 알고보니 입력이 M과 N이다 N과 M일줄 알았는데
// 먼저 벽을 최소한도로 부서야 하며 4방향으로 벡터가 있다 가중치는 모두 동일하기 때문에 0으로 고려했는데
// 이동하는 가중치는 동일하지만 벽을 적게 부수고 많이 부수고의 차이가 있다
// wall 이라는 입력값과 visit 방문 배열을 통해서 방문 여부를 판단하고
// 적게 벽을 부수고 왔으면 이미 방문한거니까 배제하기로 했다 이게 다익스트라 개념인가? 현재의 가중치가 더 크면 배제하는..?
// 그래서 pq 를 통해 가중치가 작고 조건분기로 벽의 개수를 반환한다.
// 풀이 개선 고려 feed back
// 0 - 1 BFS 로 하면되겠네 양방향 큐 deque 를 통해 벽을 부수면 뒤에서 넣고 안부수면 앞으로 가고 맞지