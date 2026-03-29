package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_2665 {
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
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] cnt = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cnt[i], 100);
        }

        pq.offer(new Node(0, 0, 0));
        cnt[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int cy = cur.y;
            int cx = cur.x;

            if (cnt[cy][cx] < cur.w) {
                continue;
            }

            if (cy == n - 1 && cx == n - 1) {
                return cur.w;
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
                        pq.offer(new Node(ny, nx, cnt[ny][nx]));
                    }
                } else {
                    if (cnt[ny][nx] > cur.w) {
                        pq.offer(new Node(ny, nx, cur.w));
                        cnt[ny][nx] = cur.w;
                    }
                }
            }
        }
        return -1;
    }

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int w;

        Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.w = cnt;
        }

        @Override
        public int compareTo(Node node) {
            if (this.w == node.w) {
                if (this.y == node.y) {
                    return node.x - this.x;
                }
                return node.y - this.y;
            }
            return this.w - node.w;
        }
    }
}
// 미로만들기 G4 다익스트라
// 33분
// 일단 풀었다. 다익스트라인거 어케 알았냐면 벽을 깨는 갯수에 대해서 가중치를 두고 시작점부터 끝점까지
// 적게 깨는거로 간다 근데 만약 벽을 1개도 안깨고 가면 그게 BFS 가 될 수 있는데 벽이 무조건 깨야되는경우
// 벽에 대해서 가중치를 작은것부터 진행해야되는데 더해서 y랑 x 좌표가 큰거로 해서 Comparable 로 정렬하고
// cnt 배열을 통해서 n이 50이니까 최대 깨는횟수로 고려하면 98개라고 생각했다 왜냐하면 시작부터 행1개 열1개 벽을 다 깨면
// 98이니까 그래서 100으로 초기화해서 접근해서 cnt를 초기화 하고 또 cnt 가중치 갱신에 대해서 continue 조건과
// 현재 cy cx 좌표의 값에 대해 분기를 하고 4방향 벡터로 해서 벽일 경우에는 가중치 +1 해서 판단하고 아니면 그냥 현재 가중치 비교해서
// 진행 해서 끝점일때 조기 반환해서 값 출력.
