/**
 * 14497 - 주난의 난 [성공(다른풀이)]
 * 골드4, BFS/버퍼큐, 시도1
 * 
 * 이 문제를 푸는 방법은 2개가 있다.
 * 1. DFS로 한번 탐색 시 벽을 만나면 해당 벽을 0으로 바꾸고 방문 표시한 뒤 방문하지 않고 갈 수 있는 곳만 방문하여 다음 DFS에서 방문토록 하는 방법.
 * 2. 큐와 버퍼큐를 사용해 큐에는 현재 갈 수 있는 모든 좌표를 저장하고, 버퍼 큐에는 다음에 갈 수 있는 좌표들을 저장하여 한 번 큐를 비울때마다 다음에 버퍼큐로 채워 다시 돌리며 벽을 지워나가는 방법.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_14497_2 {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int y1, x1, y2, x2;

    static int bfs() {
        int cnt = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayDeque<Integer> buf = new ArrayDeque<>();

        q.add(y1); q.add(x1);
        visited[y1][x1] = true;
        while (true) {
            cnt++;
            while (!q.isEmpty()) {
                int y = q.poll();
                int x = q.poll();

                if (y == y2 && x == x2) return cnt;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                    if (visited[ny][nx]) continue;
                    if (map[ny][nx] == '1') {
                        buf.add(ny); buf.add(nx);
                        visited[ny][nx] = true;
                        map[ny][nx] = '0';
                        continue;
                    }

                    q.add(ny); q.add(nx);
                    visited[ny][nx] = true;
                }
            }

            while (!buf.isEmpty())
                q.add(buf.poll());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken())-1;
        x1 = Integer.parseInt(st.nextToken())-1;
        y2 = Integer.parseInt(st.nextToken())-1;
        x2 = Integer.parseInt(st.nextToken())-1;

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int y = 0; y < N; y++) {
            String m = br.readLine();
            for (int x = 0; x < M; x++) {
                map[y][x] = m.charAt(x);
            }
        }

        System.out.println(bfs());
    }
}
