package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1981 {
    static int n;
    static int[][] map;
    static int min = 200, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int lo = -1;
        int hi = 200;


        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (reach(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        System.out.println(hi);
    }

    static boolean reach(int mid) {

        int start = Math.max(min, map[0][0] - mid);
        int end = Math.min(max, map[0][0]);

        for (int i = start; i <= end; i++) {
            int left = i;
            int right = i + mid;

            if (map[n - 1][n - 1] >= left && map[n - 1][n - 1] <= right) {
                if (bfs(left, right)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static boolean bfs(int left, int right) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][n];

        queue.offer(new Node(0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.y == n - 1 && cur.x == n - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n || visit[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] >= left && map[ny][nx] <= right) {
                    queue.offer(new Node(ny, nx));
                    visit[ny][nx] = true;
                }
            }
        }
        return false;
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
// P5 배열에서 이동 이분탐색 BFS
// 1시간 20분 힌트봄 다시
// 구하고자하는것은 최대 최소의 차이가 가장 작은것인데 이는 최소로 얻는것이고
// 이분탐색 접근해서 FFFFTTTT 로 해서 가장 첫번째 hi 를 구함 근데 bfs 로 갈 수 있는것에 대해 구했다.
// reach 의 경우 mid 가 정해졌을 때 구간 내의 숫자들만 밟고 지나가야되는데
// 최솟값 left 는 아무리 커도 시작점을 넘을 수 없고 작아도 map[0][0] - mid 보다 작을 수 없다.