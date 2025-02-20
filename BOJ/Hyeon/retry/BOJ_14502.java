package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static int N, M;
    static int[][] map;
    static int[][] tmpMap;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tmpMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 백트래킹 벽 넣기
        makeWall(0);
        System.out.println(res);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void makeWall(int depth) {
        if (depth == 3) {
            makeVirus();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void makeVirus() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.arraycopy(map[i], 0, tmpMap[i], 0, M);
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpMap[i][j] == 2) {
                    dfs(i, j);
                }
            }
        }
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpMap[i][j] == 0) {
                    size++;
                }
            }
        }
        res = Math.max(res, size);
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && nx < M && ny < N && tmpMap[ny][nx] == 0) {
                tmpMap[ny][nx] = 2;
                dfs(ny, nx);
            }
        }
    }
}


// 벽세우고
// 바이러스 퍼트리고