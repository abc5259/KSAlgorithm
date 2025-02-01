/**
 * [G2 구현] 새로운 게임 - O, 01:45:06
 * 시도 1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17780 {

    public static final int WHITE = 0;
    public static final int RED = 1;
    public static final int BLUE = 2;

    private static int[] dy = {0, 0, -1, 1};
    private static int[] dx = {1, -1, 0, 0};

    private static class Horse {
        int y, x, dir, k;

        public Horse(int y, int x, int dir, int k) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] chess = new int[n+1][n+1];
        for (int y = 1; y <= n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= n; x++) chess[y][x] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<ArrayList<Horse>>> horses = new ArrayList<>();
        ArrayList<Horse> loop = new ArrayList<>();
        for (int y = 0; y <= n; y++) {
            horses.add(new ArrayList<>());
            for (int x = 0; x <= n; x++) horses.get(y).add(new ArrayList<>());
        }

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            Horse horse = new Horse(y, x, dir - 1, i);
            horses.get(y).get(x).add(horse);
            loop.add(horse);
        }

        boolean flag = false;
        int turn = 0;
        while (turn < 1000) {
            for (Horse horse : loop) {
                if (horses.get(horse.y).get(horse.x).size() >= 4) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;

            for (Horse horse : loop) {
                ArrayList<Horse> horseList = horses.get(horse.y).get(horse.x);
                Horse base = horseList.get(0);
                if (base.k == horse.k) {
                    int y = base.y;
                    int x = base.x;

                    int ny = y + dy[horse.dir];
                    int nx = x + dx[horse.dir];

                    if (ny <= 0 || ny > n || nx <= 0 || nx > n || chess[ny][nx] == BLUE) {
                        horse.dir ^= 1;
                        ny = y + dy[horse.dir];
                        nx = x + dx[horse.dir];
                        if (ny <= 0 || ny > n || nx <= 0 || nx > n || chess[ny][nx] == 2) continue;
                    }

                    if (chess[ny][nx] == WHITE) {
                        for (Horse value : horseList) {
                            value.y = ny;
                            value.x = nx;
                        }
                        horses.get(ny).get(nx).addAll(horseList);
                        horseList.clear();
                    } else if (chess[ny][nx] == RED) {
                        ArrayDeque<Horse> q = new ArrayDeque<>();
                        for (Horse value : horseList) {
                            q.push(value);
                            value.y = ny;
                            value.x = nx;
                        }
                        for (int i = 0; i < horseList.size(); i++) horses.get(ny).get(nx).add(q.pop());
                        horseList.clear();
                    }
                }
            }
            turn++;
        }

        if (flag) System.out.println(turn);
        else System.out.println(-1);
    }
}
