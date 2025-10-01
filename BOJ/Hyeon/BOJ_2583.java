package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2583 {
    static int M, N;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        visit = new boolean[M][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == 0) {
                    pq.offer(bfs(i, j));
                }
            }
        }

        System.out.println(pq.size());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.print(sb);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        int area = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            area++;

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= M || nx >= N || visit[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 1) {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
        return area;
    }
}
// S1 영역 구하기 bfs
// 이것도 15분
// 일단 쉽게 생각 해서 4방탐색을 하는 map 이 주어졌다 그리고 주어진 색칠된 공간을 map 으로 해서 1로 초기화 시켜서
// 이로 빈 칸을 탐색할 수 있게 만들었다
// 그리고 방문 여부를 visit 으로 만들고 나서
// 해당 분리된 영역의 갯수와 그 영역의 넓이를 오름차순으로 출력해야되기때문에
// 적절한 자료구조가 PriorityQueue 라고 생각해서 썻다.
// 그리고 poll 될때마다 area++ 해줬다.
