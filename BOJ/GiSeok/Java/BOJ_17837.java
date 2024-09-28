// N*N 크기인 체스판, K개의 말 (말은 중첩될 수 있다.)
// 체스판 무작위로 말 K개를 놓고 게임 시작. 말은 1-K까지 번호가 있으며 이동방향이 존재 (상하좌우)
// 1턴마다 1번 말부터 K번 말까지 순서대로 이동, 이동 시 위에 중첩된 다른 말도 같이 이동한다.
// 이동하려는 칸에 따라 말의 이동이 달라짐 (조건부이동)
// 4개 이상의 말이 쌓이면 게임이 종료 (종료조건)

// A번 말이 이동하려는데,
//	흰색(0)		ㅡ 그 칸으로 이동, 말이 이미 있다면 가장 위에 A번 말을 올림. A번과 함께 딸린 다른 말도 같이 올라감.
//	빨간색(1)		ㅡ 이동 후 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 함.
//				ㅡ 즉, EC가 있는 칸에 AB가 간다면, ECBA가 됨.
//  파란색(2)		ㅡ A번 말의 이동 방향을 반대로 하고(영구적) 한 칸 이동, but 이동하려는 칸이 파란색이면 이동하지 않는다. and 체스판 벗어나면 파란색처럼 함
// 오1 왼2 상3 하4
// 4 <= N <= 12
// 4 <= K <= 10
// 구현 문제로 예상함.
/**
 * 17837 - 새로운 게임 2 [성공|02:08:27]
 * 골드2, 구현, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_17837 {

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static int n, k;
    static int[][][] map;

    static class horse {
        int y, x;
        int dir;

        public horse(int y, int x, int dir) {
            this.y = y; this.x = x; this.dir = dir;
        }
    }

    static boolean check() {
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                int cnt = 0;
                for (int c = 1; c <= k; c++) {
                    if (map[y][x][c] != 0) cnt++;
                }
                if (cnt >= 4) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1][k+1];
        for (int y = 1; y <= n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= n; x++) {
                map[y][x][0] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<horse> horses = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            map[y][x][1] = i+1;
            horses.add(new horse(y, x, dir-1));
        }

        int ret = 0;
        while (true) {

            boolean exit = false;

            if (ret > 1000) { ret = -1; break; }

            ArrayDeque<Integer> qstk = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {

                horse h = horses.get(i);

                int ny = h.y + dy[h.dir];
                int nx = h.x + dx[h.dir];

                // 맵의 범위를 벗어나거나 파란색이면,
                if (ny < 1 || nx < 1 || ny > n || nx > n || map[ny][nx][0] == 2) {

                    h.dir ^= 1;
                    ny = h.y + dy[h.dir];
                    nx = h.x + dx[h.dir];
                    if (ny < 1 || nx < 1 || ny > n || nx > n || map[ny][nx][0] == 2) continue;

                }

                if (map[ny][nx][0] == 1) { // 빨간색
                    for (int idx = 1; idx <= k; idx++) {

                        if (map[h.y][h.x][idx] == i+1) {
                            for (int z = idx; z <= k; z++) {
                                if (map[h.y][h.x][z] != 0) {
                                    qstk.push(map[h.y][h.x][z]);
                                    map[h.y][h.x][z] = 0;
                                }
                            }

                            break;
                        }
                    }

                    for (int idx = 1; idx <= k; idx++) {
                        if (map[ny][nx][idx] == 0 && !qstk.isEmpty()) {
                            map[ny][nx][idx] = qstk.pop();
                            horse hs = horses.get(map[ny][nx][idx] - 1);
                            hs.y = ny;
                            hs.x = nx;
                        }
                    }
                } else {
                    for (int idx = 1; idx <= k; idx++) {

                        if (map[h.y][h.x][idx] == i+1) {
                            for (int z = idx; z <= k; z++) {
                                if (map[h.y][h.x][z] != 0) {
                                    qstk.add(map[h.y][h.x][z]);
                                    map[h.y][h.x][z] = 0;
                                }
                            }

                            break;
                        }
                    }

                    for (int idx = 1; idx <= k; idx++) {
                        if (map[ny][nx][idx] == 0 && !qstk.isEmpty()) {
                            map[ny][nx][idx] = qstk.poll();
                            horse hs = horses.get(map[ny][nx][idx] - 1);
                            hs.y = ny;
                            hs.x = nx;
                        }
                    }
                }

                if (check()) { exit = true; break; }
            }

            ret++;
            if (exit) break;
        }

        System.out.println(ret);
    }
}
