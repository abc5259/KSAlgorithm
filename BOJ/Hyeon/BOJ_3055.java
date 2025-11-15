package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3055 {
    static int R, C;
    static int resY, resX;
    static char[][] map;
    static int[][] time;
    static ArrayDeque<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        queue = new ArrayDeque<>();
        time = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(time[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    queue.offerFirst(new int[]{i, j});
                    time[i][j] = 0;
                } else if (map[i][j] == '*') {
                    queue.offerLast(new int[]{i, j});
                    time[i][j] = 0;
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
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            if (cy == resY && cx == resX) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 'X') {
                    continue;
                }
                if (time[ny][nx] != -1) {
                    if (map[cy][cx] == '*' && map[ny][nx] == '*') {
                        continue;
                    } else if (map[cy][cx] == 'S') {
                        continue;
                    }
                }

                if (map[ny][nx] == 'D' && map[cy][cx] == '*') {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                map[ny][nx] = map[cy][cx];
                time[ny][nx] = time[cy][cx] + 1;
            }
        }
    }
}
// G4 탈출 BFS
// 1시간
// 일단 고슴도치가 비버굴까지 가는 최단 거리 시간 + 그리드 형태로 주어진 입력값 + 물도 플러드필 처럼 됨
// 홍수를 일으키려고 한다라니까,, 그래서 BFS 라고 생각
// 그런데 한가지 의문점
// 고슴도치가 다녀간 곳이나 이런 곳들은 물이 올 수 있지않냐? 그럼 BFS 의 특성상 한번 방문한곳은 재방문 안해야되는데
// 이를 어떻게 설명이 가능할까
// 먼저 풀이는 고슴도치가 먼저 움직인다고 생각해서 ArrayDeque 을 통해서 First로 입력받고 물은 Last 로 입력받는다
// 그리고 time 으로 방문 여부 및 물과 고슴도치의 이동시간을 구한다. 근데 생각해보니 물의 이동시간은 구할 필요가 없었다..
// 2개의 움직임을 1개의 방문여부 배열로 다뤘고
// 또 더해서 고슴도치와 물의 이동하는 장소마다 다시 뭐가 왔는지 표시하기위해 map 에 다시 체크했다
// 그래서 내가 고민했던 점 -1 이 아닐 때 내가 만약 물이었으면 이동할 장소가 고슴도치가 다녀간 곳이면 물을 보낼 수 있고
// 물 -> 물은 의미없다, 그리고 고슴도치 입장에서는 내가 이미 방문했던 물이든 고슴도치 이동 거리든 간에 다 못가서 continue 로 처리했다.
