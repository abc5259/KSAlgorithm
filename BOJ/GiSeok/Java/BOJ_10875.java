/**
 * [P5 구현] 뱀 - X, 03:14:32
 * 시도 8
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10875 {

    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    private static class Command {
        long time;
        char cmd;

        public Command(long time, char cmd) {
            this.time = time;
            this.cmd = cmd;
        }
    }

    private static class Snake {
        long sy, sx;
        long ey, ex;

        public Snake(long sy, long sx, long ey, long ex) {
            this.sy = sy;
            this.sx = sx;
            this.ey = ey;
            this.ex = ex;

            if (this.sy > this.ey) {
                long tmp = this.sy;
                this.sy = this.ey;
                this.ey = tmp;
            }
            if (this.sx > this.ex) {
                long tmp = this.sx;
                this.sx = this.ex;
                this.ex = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        ArrayList<Command> cmd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long time = Long.parseLong(st.nextToken());
            char c = st.nextToken().charAt(0);

            cmd.add(new Command(time, c));
        }

        ArrayList<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(-l-1, -l-1, l+1, -l-1));
        snakes.add(new Snake(l+1, -l-1, l+1, l+1));
        snakes.add(new Snake(l+1, l+1, -l-1, l+1));
        snakes.add(new Snake(-l-1, l+1, -l-1, -l-1));
        long y = 0;
        long x = 0;
        int dir = 0;

        long ret = 0;

        boolean done = false;
        Command command;
        for (int i = 0; i < cmd.size()+1; i++) {
            if (i == cmd.size()) {
                command = new Command(Long.MAX_VALUE, 'L');
            } else {
                command = cmd.get(i);
            }

            long t = Long.MAX_VALUE;
            for (int idx = 0; idx < snakes.size(); idx++) {
                if (snakes.get(idx).ey == snakes.get(idx).sy) {
                    if (dir == 0) { // 오른
                        if (y == snakes.get(idx).ey && x < snakes.get(idx).sx)
                            t = Math.min(t, snakes.get(idx).sx - x);
                    } else if (dir == 1) { // 위
                        if (snakes.get(idx).sx <= x && x <= snakes.get(idx).ex && y < snakes.get(idx).sy)
                            t = Math.min(t, snakes.get(idx).sy - y);
                    } else if (dir == 2) { // 왼
                        if (snakes.get(idx).ey == y && x > snakes.get(idx).ex)
                            t = Math.min(t, x - snakes.get(idx).ex);
                    } else { // 아래
                        if (snakes.get(idx).sx <= x && x <= snakes.get(idx).ex && y > snakes.get(idx).sy)
                            t = Math.min(t, y - snakes.get(idx).sy);
                    }
                } else if (snakes.get(idx).ex == snakes.get(idx).sx) {
                    if (dir == 0) {
                        if (snakes.get(idx).sy <= y && y <= snakes.get(idx).ey && x < snakes.get(idx).sx)
                            t = Math.min(t, snakes.get(idx).sx - x);
                    } else if (dir == 1) {
                        if (snakes.get(idx).sx == x && y < snakes.get(idx).sy)
                            t = Math.min(t, snakes.get(idx).sy - y);
                    } else if (dir == 2) {
                        if (snakes.get(idx).ey >= y && y >= snakes.get(idx).sy && x > snakes.get(idx).sx)
                            t = Math.min(t, x - snakes.get(idx).sx);
                    } else {
                        if (snakes.get(idx).sx == x && y > snakes.get(idx).ey)
                            t = Math.min(t, y - snakes.get(idx).ey);
                    }
                }
            }

            if (command.time < t) {
                snakes.add(new Snake(y, x, y + dy[dir] * command.time, x + dx[dir] * command.time));
                ret += command.time;
                y = y + dy[dir] * command.time;
                x = x + dx[dir] * command.time;

                if (command.cmd == 'L') dir = (dir + 1) % 4;
                else dir = (dir - 1 < 0) ? 3 : dir - 1;
            } else {
                ret += t;
                break;
            }
        }

        System.out.println(ret);
    }
}

/*
100000000
5
100000000 L
100000000 L
200000000 L
199999999 L
199999999 L

4
5
1 L
1 L
2 L
1 L
2 R
-> 6

4
4
1 L
1 L
2 L
1 L

4
5
1 L
1 L
2 L
1 L
5 R
-> 6
 */