package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.lang.Comparable;

public class BOJ_1520 {

    static class Node implements Comparable<Node> {
        public int num;
        public int x;
        public int y;

        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return o.num - this.num;
        }
    }

    static int[][] wasd = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int[][] map;
    static int[][] visited;
    static int N, M;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        bfs();
        System.out.println(visited[M-1][N-1]);
    }

    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(map[0][0], 0, 0));
        visited[0][0] = 1;

        while (!pq.isEmpty()) {
            Node p = pq.poll();

            for (int i = 0; i < 4; i++) {
                int xx = p.x + wasd[i][0];
                int yy = p.y + wasd[i][1];
                if ((xx >= 0 && xx < N) && (yy >= 0 && yy < M)) {
                    if (p.num > map[yy][xx]) {
                        if (visited[yy][xx] == 0)
                            pq.add(new Node(map[yy][xx], xx, yy));
                        visited[yy][xx] += visited[p.y][p.x];
                    }
                }
            }
        }
    }
}