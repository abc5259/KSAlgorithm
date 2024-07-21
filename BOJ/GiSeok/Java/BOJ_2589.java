/**
 * 2589 - 보물섬 [성공|00:36:48]
 * 골드5, BFS, 시도1
 * 
 * BFS는 시작 지점에 따라 시작 위치 - 가장 먼 곳의 크기가 다르다.
 * 그러므로 모든 땅 좌표에 대해서 BFS를 돌려 가장 큰 차이가 나는 곳(시작지점, 가장 먼 곳)에 보물이 있다!!
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2589 {
    // 시간제한 1초
    // 육지 L, 바다 W
    // 상하좌우 이웃한 육지로만 이동 가능.
    // 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻힘.=> BFS?
    // BFS는 시작 지점에 따라 가장 먼 곳의 크기가 달라지므로 모든 'L' 좌표를 저장하고 모든 'L' 좌표에 대해서 BFS를 돌림.
    // 돌린 후 visited 배열의 차가 가장 큰 값을 출력.
    // 모든 L 좌표 탐색 => 50^2 (지도가 전부 땅일 수 있으니까)
    // L 좌표마다 BFS 탐색 => 50^2
    // 시간복잡도 = 50^4 = 620만

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Pair> grounds = new ArrayList<>();
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'L') grounds.add(new Pair(i, j));
            }
        }

        int max = 0;
        for (Pair r : grounds) {
            ArrayDeque<Pair> q = new ArrayDeque<>();
            visited = new int[N][M];

            q.add(new Pair(r.y, r.x));
            visited[r.y][r.x] = 1;

            Pair p = r;
            while (!q.isEmpty()) {
                p = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = p.y + dy[i];
                    int nx = p.x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                    if (visited[ny][nx] > 0) continue;
                    if (map[ny][nx] == 'W') continue;

                    visited[ny][nx] = visited[p.y][p.x] + 1;
                    q.add(new Pair(ny, nx));
                }
            }

            max = Math.max(max, visited[p.y][p.x] - visited[r.y][r.x]);
        }

        System.out.println(max);
    }
}
