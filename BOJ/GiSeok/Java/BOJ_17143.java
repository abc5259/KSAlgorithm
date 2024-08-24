/**
 * 17143 - 낚시왕 [실패]
 * 골드1, 구현, 시도2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17143 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int r, c, m;
    static int[][] map;
    static int[][] temp;
    static int ret = 0;

    static class shark {
        int y, x;
        int size;
        int dir;
        int speed;
        boolean death;

        public shark(int y, int x, int s, int d, int z) {
            this.y = y;
            this.x = x;
            this.speed = s;
            this.dir = d;
            this.size = z;
            this.death = false;
        }

        public shark() {}
    }

    static ArrayList<shark> sharks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        sharks.add(new shark());
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int size = Integer.parseInt(st.nextToken());
            sharks.add(new shark(y, x, s, d, size));

            if (d <= 1) sharks.get(i).speed %= (2 * (r - 1));
            else sharks.get(i).speed %= (2 * (c - 1));
            map[y][x] = i;
        }

        for (int t = 0; t < c; t++) {

            for (int y = 0; y < r; y++) {
                if (map[y][t] > 0) {
                    sharks.get(map[y][t]).death = true;
                    ret += sharks.get(map[y][t]).size;
                    map[y][t] = 0;
                    break;
                }
            }

            temp = new int[r][c];
            for (int idx = 1; idx <= m; idx++) {
                if (sharks.get(idx).death) continue;

                int y = sharks.get(idx).y;
                int x = sharks.get(idx).x;
                int s = sharks.get(idx).speed;
                int d = sharks.get(idx).dir;
                int ny, nx;

                while (true) {
                    ny = y + s * dy[d];
                    nx = x + s * dx[d];

                    if (ny < r && nx < c && ny >= 0 && nx >= 0) break;
                    if (d <= 1) {
                        if (ny < 0) {
                            s -= y;
                            y = 0;
                        } else {
                            s -= r - 1 - y;
                            y = r-1;
                        }
                    } else {
                        if (nx < 0) {
                            s -= x;
                            x = 0;
                        } else {
                            s -= c-1-x;
                            x = c-1;
                        }
                    }

                    d ^= 1;
                }

                if (temp[ny][nx] > 0) {
                    if (sharks.get(temp[ny][nx]).size > sharks.get(idx).size)
                        sharks.get(idx).death = true;
                    else {
                        sharks.get(temp[ny][nx]).death = true;
                        temp[ny][nx] = idx;
                    }
                } else temp[ny][nx] = idx;

                sharks.get(idx).y = ny;
                sharks.get(idx).x = nx;
                sharks.get(idx).dir = d;
            }

            for (int i = 0; i < r; i++) map[i] = temp[i].clone();
        }

        System.out.println(ret);
    }
}
