package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18405 {
    static int N;
    static int[][] map;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[3] == o2[3]) {
                    return o1[2] - o2[2];
                }
                return o1[3] - o2[3];
            }
        });

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.offer(new int[]{i, j, map[i][j], 0});
                }
            }
        }
        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        bfs(S, X, Y);

        System.out.println(map[X][Y]);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int time, int y, int x) {

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cy = poll[0];
            int cx = poll[1];
            int type = poll[2];
            int sec = poll[3];

            if ((cy == y && cx == x) || sec == time) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 1 || nx < 1 || ny > N || nx > N || map[ny][nx] != 0) {
                    continue;
                }
                map[ny][nx] = type;
                pq.offer(new int[]{ny, nx, type, sec + 1});
            }
        }
    }
}
// G5 경쟁적 전염 BFS
// 1시간 10분 오래 걸림 PQ 고민 못했음
// 일단 중요한게 시간 단위로 BFS 를 해야되기 때문에 내가 초단위로 반복 완탐 하려고 했는데
// 걍 루트가 여러개인 bfs 인가?? 그래서 다중 노드를 가지는 BFS 를 했다.
// 그리고 방문여부는 map 으로도 가능하니까,, visit 따로 쓸 필요없고
// 그래서 PQ를 써서 y, x, virus type, sec 해서 연산했다. offer 과 map 에 넣어서 방문여부 확인시키고,,
