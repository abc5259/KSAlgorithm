package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_1 {
    static int r, c;
    static int[][] map;
    static boolean[][] visit;
    static int haveCheese;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    haveCheese++;
                }
            }
        }
        int time = 0;
        int lastCheese = 0;

        while (haveCheese > 0) {
            time++;
            lastCheese = haveCheese;

            int melt = bfs();

            haveCheese -= melt;
        }
        System.out.println(time + "\n" + lastCheese);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        visit = new boolean[r][c];
        visit[0][0] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= r || nx >= c || visit[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    queue.offer(new int[]{ny, nx});
                } else {
                    cnt++;
                    map[ny][nx] = 0;
                }
                visit[ny][nx] = true;
            }
        }
        return cnt;
    }
}
// G4 치즈 BFS
// another sol
// list 로 따로 빼지말고 그냥 변수화 해서 사용 그리고 melting 이라는 메소드도 그냥
// bfs 내에서 작동하게 한다.