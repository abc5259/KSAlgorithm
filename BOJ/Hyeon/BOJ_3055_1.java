package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3055_1 {
    static int R, C;
    static int resY, resX;
    static char[][] map;
    static int[][] time; // 고슴도치 전용 방문 시간이어야함

    static ArrayDeque<int[]> q_hedgehog;
    static ArrayDeque<int[]> q_water;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        time = new int[R][C];
        q_hedgehog = new ArrayDeque<>();
        q_water = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(time[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    q_hedgehog.offer(new int[]{i, j});
                    time[i][j] = 0;
                } else if (map[i][j] == '*') {
                    q_water.offer(new int[]{i, j});
                } else if (map[i][j] == 'D') {
                    resY = i;
                    resX = j;
                }
            }
        }

        bfs();

        int res = time[resY][resX];
        System.out.println(res != -1 ? res : "KAKTUS");
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs() {

        while (!q_hedgehog.isEmpty()) {
            int waterSize = q_water.size();

            for (int i = 0; i < waterSize; i++) {
                int[] poll = q_water.poll();

                int cy = poll[0];
                int cx = poll[1];

                for (int d = 0; d < 4; d++) {
                    int ny = cy + dy[d];
                    int nx = cx + dx[d];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        continue;
                    }

                    if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
                        map[ny][nx] = '*';
                        q_water.offer(new int[]{ny, nx});
                    }
                }
            }

            int hedgehogSize = q_hedgehog.size();
            for (int i = 0; i < hedgehogSize; i++) {
                int[] poll = q_hedgehog.poll();

                int cy = poll[0];
                int cx = poll[1];

                for (int d = 0; d < 4; d++) {
                    int ny = cy + dy[d];
                    int nx = cx + dx[d];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        continue;
                    }

                    if (resY == ny && resX == nx) {
                        time[ny][nx] = time[cy][cx] + 1;
                        return;
                    }

                    if (map[ny][nx] == '.' && time[ny][nx] == -1) {
                        time[ny][nx] = time[cy][cx] + 1;
                        q_hedgehog.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
// G4 탈출 BFS another sol
// 일단 다른 풀이
// 2개의 BFS를 돌리고 물의 이동 시간을 구할 필요 없음
// 고슴도치가 갈 곳이 없을 때까지 진행해서
// 물이 먼저 퍼지게 한다음 고슴도치가 갈 수 있는 곳을 찾아가게 한다.