/**
 * 1987 - 알파벳 [성공|00:16:43]
 * 골드4, DFS, 시도1
 * 
 * 이전에 지나온 알파벳은 지나면 안되는 문제.
 * 이전에 지나온 알파벳을 표시하기 위해 visited 배열을 사용하였다.
 * 문제의 시간 복잡도
 * 3^26
 * 그러나, 실제로 이만큼의 함수호출은 일어나지 않는다. 왜냐면, 지나온 알파벳은 지나지 않는다는 조건이 있기 때문이다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
    // 시간제한 2초, 메모리제한 256MB

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] map;
    static boolean[] visited = new boolean[26];;
    static int N, M;
    static int ret = 0;

    static void dfs(int y, int x, int cnt) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            int next = map[ny][nx] - 'A';
            if (visited[next]) continue;

            visited[next] = true;
            dfs(ny, nx, cnt + 1);
            visited[next] = false;
        }

        ret = Math.max(ret, cnt);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            String m = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = m.charAt(x);
            }
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(ret);
    }
}
