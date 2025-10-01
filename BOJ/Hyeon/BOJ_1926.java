package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1926 {
    static int n, m;
    static boolean[][] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    max = Math.max(bfs(i, j), max);
                    cnt++;
                }
            }
        }
        System.out.print(cnt + "\n" + max);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        int size = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx] || map[ny][nx] == 0) {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
        return size;
    }
}
// S1 그림 bfs
// 15분
// 일단 map 형태로 입력값이 주어졌기에 격자를 사용했다
// 그리고 그리드를 통해서 1인 곳들의 연결상태 4방탐색을 확인
// 해서 bfs로 뻗어나기는 거기때무넹 2개 배열을 해주고 방향을 가지는
// 그리고 방문 여부를 통해서 우리가 안 간 곳 + 1일 때의 횟수 == 그림의 갯수 이고
// 각 bfs 마다 큐에서 나오는 값들이 그림의 크기이기때문에 bfs 가 이를 리턴하게 하면된다
// 그걸 통해서 continue 문의 조건을 잘 신경써야되고 map 이 0이거나 방문했으면 continue 처럼
// 그래서 이를 반복해서 비교하면된다 n 이랑 m 500이기 떄문에