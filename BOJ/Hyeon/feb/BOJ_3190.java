package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        ArrayDeque<Rotate> roll = new ArrayDeque<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            roll.offer(new Rotate(time, dir));
        }
        int y = 1;
        int x = 1;
        int dir = 1; // 처음엔 동쪽
        int time = 0;

        ArrayDeque<Point> snake = new ArrayDeque<>();
        snake.offer(new Point(y, x));
        map[y][x] = 2;

        while (true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            time++;

            if (ny < 1 || nx < 1 || ny > N || nx > N) {
                break;
            }
            if (map[ny][nx] == 2) {
                break;
            }
            if (map[ny][nx] == 0) {
                Point p = snake.poll();
                map[p.y][p.x] = 0;
            }
            if (!roll.isEmpty()) {
                if (time == roll.peek().cnt) {
                    Rotate r = roll.poll();
                    if (r.dir.equals("L")) {
                        dir = dir - 1 < 0 ? 3 : dir - 1;
                    } else {
                        dir = dir + 1 > 3 ? 0 : dir + 1;
                    }
                }
            }
            map[ny][nx] = 2;
            snake.offer(new Point(ny, nx));
            y = ny;
            x = nx;
        }
        System.out.println(time);
    }

    static int[] dy = {-1, 0, 1, 0,};
    static int[] dx = {0, 1, 0, -1};

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Rotate {
        int cnt;
        String dir;

        public Rotate(int cnt, String dir) {
            this.cnt = cnt;
            this.dir = dir;
        }
    }
}
