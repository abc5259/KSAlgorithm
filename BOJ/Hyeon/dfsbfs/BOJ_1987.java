package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
    static int R, C;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visit = new boolean[26];
        String str;

        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        visit[arr[0][0] - 'A'] = true;

        dfs(0, 0, 1);
        System.out.println(cnt);
    }

    static int cnt = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[] visit;

    static void dfs(int y, int x, int depth) {
        cnt = Math.max(cnt, depth);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
                int idx = arr[ny][nx] - 'A';
                if (!visit[idx]) {
                    visit[idx] = true;
                    dfs(ny, nx, depth + 1);
                    visit[idx] = false;
                }
            }
        }
    }
}