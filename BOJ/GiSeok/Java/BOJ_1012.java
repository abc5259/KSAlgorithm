/**
 * 1012 - 유기농 배추 [성공|00:11:30]
 * 
 * 지렁이가 상하좌우로 이동하면서 인접한 모든 배추에 갈 수 있다.
 * 그래서 이러한 서로 인접한 배추들끼리는 지렁이가 1마리만 필요하다.
 * => 인접한 배추들이 몇 군데 있는지 조사해서, 몇 마리의 지렁이가 필요한가?
 * 즉, 배추의 연결 그래프 갯수를 구해서 총 몇 마리의 지렁이가 필요한지 구하는 문제
 * => 연결 컴포넌트 문제
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
    // 지렁이 -> 상하좌우로 이동 가능
    // 하나의 그래프에 지렁이가 한 마리라도 있으면 ok
    // 연결된 그래프의 개수를 구하는 연결 컴포넌트 문제

    static class Pair {
        int x, y;

        Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(new Pair(i, j));
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
        
    }

    static void dfs(Pair p) {
        visited[p.y][p.x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = p.y + dy[i];
            int nx = p.x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (visited[ny][nx]) continue;
            if (map[ny][nx] == 0) continue;

            dfs(new Pair(ny, nx));
        }
    }
}
