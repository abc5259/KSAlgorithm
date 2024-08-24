/**
 * 15685 - 드래곤 커브 [성공|02:16:04]
 * 골드3, 구현, 시도1
 *
 * 방향 전환을 하는 것에 좀 시간을 많이 잡아먹혔다.
 */
package week5;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15685 {
    // 시간제한 1초, 메모리제한 512MB
    // 드래곤 커브는 다음 세 가지 속성을 가지며 2차원 좌표 평면 위에서 정의된다.
    // 1. 시작 점
    // 2. 시작 방향
    // 3. 세대

    // 약간 누적합처럼 이전의 선을 90도 회전시켜 끝점에 붙이는 문제
    // 1 <= N <= 20
    // 0 <= x, y <= 100

    // 끝점을 원점으로 생각하고 회전 이동하고,
    // 끝점만큼 더 해주자. 근데, 배열은 좌표가 아래가 증가, 위가 감소이므로 빼자.

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    static int[][] map = new int[101][101];
    static int n;
    static int ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());

            ArrayList<Pair> p = new ArrayList<>();
            map[starty][startx] = 1;
            map[starty + dy[dir]][startx + dx[dir]] = 1;
            p.add(new Pair(startx, starty));
            p.add(new Pair(startx + dx[dir], starty + dy[dir]));

            for (int i = 0; i < gen; i++) {

                Pair end = p.get(p.size()-1);
                int size = p.size();
                for (int j = size-2; j >= 0; j--) {
                    Pair r = p.get(j);
                    int ny = end.y - r.y;
                    int nx = end.x - r.x;

                    int temp = -ny;
                    ny = nx;
                    nx = temp;

                    ny = -ny;
                    nx = -nx;

                    ny += end.y;
                    nx += end.x;

                    if (ny < 0 || nx < 0 || ny > 100 || nx > 100) continue;

                    map[ny][nx] = 1;
                    p.add(new Pair(nx, ny));
                }

            }
        }

        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (map[y][x] == 1) {
                    int cnt = 1;
                    if (map[y+1][x] == 1) cnt++;
                    if (map[y][x+1] == 1) cnt++;
                    if (map[y+1][x+1] == 1) cnt++;

                    if (cnt == 4) ret++;
                }
            }
        }

        System.out.println(ret);
    }
}
