/**
 * [S1 구현] 봄버맨 - O, 01:01:16
 * 시도 3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_16918 {
    // 봄버맨
    // R x C 직사각형 격자판
    // 폭탄있는 칸 3초 후 폭발 -> 상하좌우 및 폭탄 위치 파괴
    // 연쇄 반응 x

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    static class Bomb {
        int y, x, t;

        public Bomb(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayDeque<Bomb> bombs = new ArrayDeque<>();
        int[][] map = new int[r][c];
        for (int y = 0; y < r; y++) {
            String line = br.readLine();
            for (int x = 0; x < c; x++) {
                char m = line.charAt(x);
                if (m == 'O') {
                    map[y][x] = 1;
                    bombs.offer(new Bomb(y, x, 0));
                }
            }
        }

        int prev = 0;
        for (int t = 1; t <= n; t++) {
            if (prev + 2 == t) {
                for (int y = 0; y < r; y++) {
                    for (int x = 0; x < c; x++) {
                        if (map[y][x] == 0) {
                            bombs.add(new Bomb(y, x, t));
                            map[y][x] = 1;
                        }
                    }
                }
            } else if (prev + 3 == t) {
                int[][] copy = new int[r][c];
                for (int i = 0; i < r; i++)
                    copy[i] = map[i].clone();

                while (!bombs.isEmpty() && bombs.peek().t + 3 == t) {
                    Bomb poll = bombs.poll();

                    if (map[poll.y][poll.x] == 1) {
                        copy[poll.y][poll.x] = 0;
                        for (int i = 0; i < 4; i++) {
                            int ny = poll.y + dy[i];
                            int nx = poll.x + dx[i];

                            if (ny < 0 || ny >= r || nx < 0 || nx >= c)
                                continue;

                            copy[ny][nx] = 0;
                        }
                    }
                }

                for (int i = 0; i < r; i++)
                    map[i] = copy[i].clone();

                bombs.removeIf(next -> map[next.y][next.x] == 0);
                prev = t - 1;
            }
        }

        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if (map[y][x] == 0) System.out.print(".");
                else System.out.print("O");
            }
            System.out.println();
        }
    }
}
