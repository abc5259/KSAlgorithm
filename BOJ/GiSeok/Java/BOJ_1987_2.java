/**
 * 1987 - 알파벳 [성공|00:15:32]
 * 골드4, 비트마스킹/DFS, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_2 {
    // R*C로 된 보드
    // 각 칸에는 대문자 알파벳 하나씩
    // 지나갔던 대문자를 제외하고 가장 멀리가는 경우의 칸 수 출력

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] map;
    static int alphabet;
    static int R, C;
    static int ret = 0;

    static void dfs(int y, int x, int cnt) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if ((alphabet & (1 << map[ny][nx])) >= 1) continue;

            alphabet |= (1 << map[ny][nx]);
            dfs(ny, nx, cnt + 1);
            alphabet ^= (1 << map[ny][nx]);
        }

        ret = Math.max(ret, cnt);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String m = br.readLine();
            for (int j = 0; j < C; j++)
                map[i][j] = m.charAt(j) - 'A';
        }

        alphabet = (1 << map[0][0]);
        dfs(0, 0, 1);

        System.out.println(ret);
    }
}
