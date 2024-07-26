/**
 * 3197 - 백조의 호수 [실패|01:45:14]
 * 플레5, BFS
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_3197 {
    // 시간제한 1초
    // 호수 위 빙판
    // 호수는 R*C, 어떤 칸은 얼음으로 뒤덮임
    // 얼음은 치즈문제처럼 하루마다 물에 닿은 곳이 녹음.
    // 며칠 뒤에 백조는 만날 수 있을까?

    // 연결요소 안에 백조가 두 마리면? -> 백조는 만날 수 있다

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] swanvisited;
    static boolean[][] watervisited;
    static int N, M;
    static int swanX, swanY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> waterq = new ArrayDeque<>();
        ArrayDeque<Integer> waterbuf = new ArrayDeque<>();
        ArrayDeque<Integer> swanq = new ArrayDeque<>();
        ArrayDeque<Integer> swanbuf = new ArrayDeque<>();

        map = new int[N][M];
        swanvisited = new boolean[N][M];
        watervisited = new boolean[N][M];
        for (int y = 0; y < N; y++) {
            String m = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = m.charAt(x);
                if (map[y][x] == 'L') { swanX = x; swanY = y; }
                if (map[y][x] == '.' || map[y][x] == 'L') { waterq.add(y); waterq.add(x); watervisited[y][x] = true; }
            }
        }

        int ret = 0;
        boolean meet = false;
        swanq.add(swanY);
        swanq.add(swanX);
        swanvisited[swanY][swanX] = true;
        while (true) {
            while (!swanq.isEmpty()) {
                int y = swanq.poll();
                int x = swanq.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                    if (swanvisited[ny][nx]) continue;

                    swanvisited[ny][nx] = true;
                    if (map[ny][nx] == '.') {
                        swanq.add(ny);
                        swanq.add(nx);
                    }
                    else if (map[ny][nx] == 'X') {
                        swanbuf.add(ny);
                        swanbuf.add(nx);
                    }
                    else if (map[ny][nx] == 'L') meet = true;
                }
            }
            if (meet) break;
            while (!waterq.isEmpty()) {
                int y = waterq.poll();
                int x = waterq.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                    if (watervisited[ny][nx]) continue;
                    if (map[ny][nx] == 'X') {
                        watervisited[ny][nx] = true;
                        map[ny][nx] = '.';
                        waterbuf.add(ny);
                        waterbuf.add(nx);
                    }
                }
            }
            while (!waterbuf.isEmpty())
                waterq.add(waterbuf.poll());
            while (!swanbuf.isEmpty())
                swanq.add(swanbuf.poll());

            ret++;
        }

        System.out.println(ret);
    }
}
