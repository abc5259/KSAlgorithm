/**
 * 2234 - 성곽 [성공(반례힌트)|01:10:56]
 * 골드3, DFS(연결요소)/비트마스킹, 시도2
 * 
 * 땅따먹기 문제
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2234 {
    // 시간제한 2초, 메모리제한 128MB
    // 성의 굵은 선 = 벽, 점선 = 벽x
    // 1. 이 성에 있는 방의 개수
    // 2. 가장 넓은 방의 넓이
    // 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기

    // 1 <= M, N <= 50
    
    static int[][] map;
    static int[][] visited;
    static int N, M;
    static int maxroom = 0;

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};

    static int dfs(int y, int x, int type) {
        int ret = 1;
        visited[y][x] = type;

        for (int i = 0; i < 4; i++) {
            if ((map[y][x] & (1 << i)) >= 1) continue;

            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
            if (visited[ny][nx] >= 1) continue;

            ret += dfs(ny, nx, type);
        }

        return ret;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[M][N];
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] area = new int[2501];
        int room = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    area[room] = dfs(i, j, room);
                    maxroom = Math.max(area[room++], maxroom);
                }
            }
        }

        int ret = 0;
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                
                for (int i = 0; i < 4; i++) {
                    if ((map[y][x] & (1 << i)) == 0) continue;
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
                    if (visited[y][x] == visited[ny][nx]) continue;
                    ret = Math.max(ret, area[visited[y][x]] + area[visited[ny][nx]]);
                }
            }
        }

        System.out.println(room-1);
        System.out.println(maxroom);
        System.out.println(ret);
    }
}
