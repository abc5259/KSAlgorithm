package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int days = 0;

        while (true) {

            boolean flag = false;
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        int sum = bfs(i, j);

                        if (list.size() > 1) {
                            flag = true;
                            int tmp = sum / list.size();

                            for (int[] a : list) {
                                map[a[0]][a[1]] = tmp;
                            }
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
            days++;
        }

        System.out.println(days);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x) {
        list = new ArrayList<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        list.add(new int[]{y, x});
        int sum = map[y][x];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
                    continue;
                }
                int dif = Math.abs(map[cy][cx] - map[ny][nx]);
                if (dif >= L && dif <= R) {
                    queue.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;

                    list.add(new int[]{ny, nx});
                    sum += map[ny][nx];
                }
            }
        }
        return sum;
    }
}
// G4 인구이동 BFS
// 그냥 풀었다.
// 다시 풀면 좋을