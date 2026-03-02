package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                System.out.println(sb);
                return;
            }

            map = new int[N][N];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(cnt++).append(": ").append(dijkstra()).append("\n");
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] rupee = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(rupee[i], 100_000);
        }

        pq.offer(new Node(0, 0, map[0][0]));
        rupee[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int cy = cur.y;
            int cx = cur.x;

            if (cy == N - 1 && cx == N - 1) {
                return cur.w;
            }

            if (cur.w > rupee[cy][cx]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }

                if (rupee[ny][nx] > cur.w + map[ny][nx]) {
                    rupee[ny][nx] = cur.w + map[ny][nx];
                    pq.offer(new Node(ny, nx, rupee[ny][nx]));
                }
            }
        }
        return rupee[N - 1][N - 1];
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
// G4 녹색 옷 입은 애가 젤다지? 다익스트라
// 30분
// 걍 풀었다.
// 일단 DP 인가 싶었다 왜냐하면 누적해서 가는데 가장 최적의 값을 구해야해서 우측과 하단으로만 가는 줄 알고
// 근데 4방향 벡터여서 다익인가 싶었다. 가중치가 다 다르기도 했고. 최적의 경로를 구하다보니?
// DP로 풀었더니 갱신이 안되었다 탐색 순서를 정렬할 수 없기 때문에 다익스트라는 특성상 가중치가 가장 낮은거부터 오름차를 해버리기 때문에
// 그를 통해서 테케를 풀었더니 돼서 다익으로 접근
// Node 클래스 따로빼고 y와 x 좌표평면을 움직여서 값을 갖고 w 가중치로 Comparable 했다
// 이게 없이 y,x 만 있으면 정렬이 안됨
// 그리고 map 배열에 현재 비용을 다 적어두고 시작하는 0,0 부터 N-1, N-1 까지 다익을 돌렸는데
// 비용에 있어서 rupee 배열에 만들어서 충분히 큰값으로 초기화 하고 완화 했다
// 시작 가중치는 map[0][0] 으로 넣고 pq 에 넣고 했고
// 지금 루피 비용보다 현재의 가중치 + 해당 루피 비용 으로 다익스트라 이어가면서 했다.