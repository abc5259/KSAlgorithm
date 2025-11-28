package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static int N, M;
    static boolean[][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (tmp[j] == '1') {
                    map[i][j] = true;
                }
            }
        }
        System.out.println(bfs());
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            if (cy == N - 1 && cx == M - 1) {
                return visited[cy][cx][poll[2]];
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }

                if (map[ny][nx]) {
                    if (poll[2] == 1 || visited[ny][nx][poll[2] + 1] != 0) {
                        continue;
                    }
                    queue.offer(new int[]{ny, nx, poll[2] + 1});
                    visited[ny][nx][1] = visited[cy][cx][poll[2]] + 1;
                } else {
                    if (visited[ny][nx][poll[2]] != 0) {
                        continue;
                    }
                    queue.offer(new int[]{ny, nx, poll[2]});
                    visited[ny][nx][poll[2]] = visited[cy][cx][poll[2]] + 1;
                }
            }
        }
        return -1;
    }
}
// G3 벽 부수고 이동하기 BFS
// 45분
// 일단 이게 BFS 를 할 때 조건이 내가 벽을 몇개 째 깼는지 기억을 해야된다는 점이다
// 일단 최단거리이고 벽은 최대 1개 깰 수 있다
// 안된다면 -1 을 리턴하라는 점에서 나는 int 를 리턴값으로 가지는 BFS 메소드를 통해서
// BFS 의 좌표가 현재 맨 끝 좌표라면 탈출시켜서 현재 방문 횟수에 대해 리턴하는 식으로 생각했다
// 근데 여기서 visited 라는 방문여부와 이동횟수 두가지를 모두 다 가지는 배열을 만들고 이는 벽의 갯수까지 포함해서 3차원으로 만들었다
// 그다음 4방향 탐색 과정 중 다음 좌표가 벽인지 벽이 아닌지를 조건문을 걸어야 한다
// 방문 여부는 그다음에 체크하기 때문
// 벽이라면 벽을 깨야된다 그렇다는 말은 내가 지금 벽을 깰 수 있는지를 확인을 하고 벽을 더 못깬다면 넘어가고
// 아니면 그쪽으로 큐를 진행하는 것이다
// 그리고 벽이 아니라면 내가 방문한적 있는지를 점검해야된다
// 현재까지 내가 깨온 벽돌 수  + 4방 탐색 좌표의 3차원 배열에서 0이 아니라면 이미 방문한거고
// 0이면 방문을 안한거로 정리할 수 있다.