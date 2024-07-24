/**
 * 4179 - 불! [성공(반례힌트)|01:50:52]
 * 골드4, BFS, 시도12
 * 
 * 떠올린 아이디어는 불을 먼저 지피고 visited 배열을 불 기준으로 최단거리를 구해놓고,
 * 이 후에 visited 배열의 최단거리 크기에 따라 지훈이를 이동하냐마냐를 결정하여 답을 구했음.
 * 근데, 반례 중에 만약 불이 지훈이가 가는 길에 닿지 못하는 경우가 생기면 그 길은 모두 0이 되어
 * 지훈이가 불의 최단거리보다 작은 곳만 지나는 로직 (if (visited[ny][nx] <= visited[p.y][p.x] + 1) continue;)에 의해 제대로 답을 출력하지 못했다.
 * 그래서, != 0 인 경우에만 해당 로직을 실행하고, 0이면 불이 지나지 못했다는 의미이므로 그냥 지나도록 했음.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_4179 {
    // 시간제한 1초
    // 지훈이가 미로를 탈출하도록 도와주자.
    // 지훈이 위치, 불이 붙은 위치를 감안해서 지훈이가 불에 타기 전 탈출 여부와 얼마나 빨리 탈출할 수 있는지 결정
    // 지훈이와 불 매 분마다 한칸씩 상하좌우 이동
    // 불은 각 지점에서 네 방향으로 확산
    // 가장 자리로 가면 탈출이다.
    // # : 벽
    // . : 지나갈 수 있는 공간
    // J : 지훈이 초기 위치
    // F : 불 위치

    // 1 <= R, C <= 1000

    // BFS로 불 먼저 확산시키면서 visited 배열에 거리를 담고,
    // 지훈이를 이동 시키는데, 지훈이가 이동할 때 visited 배열의 원소 크기가 자신이 이동하는 거리보다 작으면? => 그 길론 갈 수 없다.
    // -> 불이 지훈이가 갈 길로 안 번지는 경우도 생각해보아야 했다.
    // 대충 한 번의 BFS마다 최대 100^2 = 100만. 근데 별개로 이루어지는 BFS이므로 + ..
    // 천 만도 안될듯?

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static int[][] visited;
    static ArrayDeque<Pair> q = new ArrayDeque<>();
    static int R, C;
    static int jy, jx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new int[R][C];

        for (int y = 0; y < R; y++) {
            String s = br.readLine();
            for (int x = 0; x < C; x++) {
                map[y][x] = s.charAt(x);
                if (s.charAt(x) == 'F') { q.add(new Pair(y, x)); visited[y][x] = 1; };
                if (s.charAt(x) == 'J') { jy = y; jx = x; }
                if (s.charAt(x) == '#') visited[y][x] = Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()) {
            Pair r = q.poll();

            for (int n = 0; n < 4; n++) {
                int ny = r.y + dy[n];
                int nx = r.x + dx[n];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (map[ny][nx] == 'J' || map[ny][nx] == '#' || map[ny][nx] == 'F') continue;
                if (visited[ny][nx] != 0 && visited[ny][nx] <= visited[r.y][r.x] + 1) continue;

                visited[ny][nx] = visited[r.y][r.x] + 1;
                q.add(new Pair(ny, nx));
            }
        }
        
        q.add(new Pair(jy, jx));
        visited[jy][jx] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.y == 0 || p.y == (R-1) || p.x == 0 || p.x == (C-1)) { System.out.println(visited[p.y][p.x]); return; }
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (map[ny][nx] == '#' || map[ny][nx] == 'F') continue;
                if (visited[ny][nx] != 0 && visited[ny][nx] <= visited[p.y][p.x] + 1) continue;

                visited[ny][nx] = visited[p.y][p.x] + 1;
                q.add(new Pair(ny, nx));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
