package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_3184 {
    static int R, C;
    static int wolf, sheep;
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.print(sheep + " " + wolf);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        int o = 0, v = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            if (map[cy][cx] == 'v') {
                v++;
            } else if (map[cy][cx] == 'o') {
                o++;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ny][nx] || map[ny][nx] == '#') {
                    continue;
                }

                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
        if (o <= v) {
            wolf += v;
        } else {
            sheep += o;
        }
    }
}
// S1 양 BFS
// 38분 문제를 이해하는데 오래걸렸다 . 을 움직이는거지 양이나 늑대가 움직이는게 아니었다.
// 일단 다 똑같이 시작하고 char 배열이 2차원 그리드로 주어졌다 map 형태이다
// 그래서 완전 탐색으로 bfs 를 터는데 일단 트러블 1개가
// 내 자리가 늑대인지 양인지도 봐야된다 왜냐하면 울타리만 아니면 ok 라서
// 그래서 그거를 bfs 입장할때 1번 검사하고
// 그다음 bfs 로직에서도 v 랑 o라는 지역변수를 통해서 계속해서 값을 가졌다가
// bfs 탈출할 때 o 랑 v 를 비교해서 해당 값을 정적변수에 증가시키면서 탈출해서 반복하는 형태이다.
// 개선
// 큐에서 꺼낼때 양인지 늑대인지 보고 continue 조건 통과하면 그냥 다 queue 에 넣어버려도될듯?
