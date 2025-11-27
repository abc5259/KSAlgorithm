package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_14442 {
    static int N, M, K;
    static boolean[][] map;
    static int[][][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        dist = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1') {
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
        dist[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            int brokenWall = poll[2];

            if (cy == N - 1 && cx == M - 1) {
                return dist[cy][cx][brokenWall];
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }

                if (map[ny][nx]) {
                    if (brokenWall < K && dist[ny][nx][brokenWall + 1] == 0) {
                        queue.offer(new int[]{ny, nx, brokenWall + 1});
                        dist[ny][nx][brokenWall + 1] = dist[cy][cx][brokenWall] + 1;
                    }
                } else {
                    if (dist[ny][nx][brokenWall] != 0) {
                        continue;
                    }
                    queue.offer(new int[]{ny, nx, brokenWall});
                    dist[ny][nx][brokenWall] = dist[cy][cx][brokenWall] + 1;
                }
            }
        }
        return -1;
    }
}
// G3 벽 부수고 이동하기 2 BFS
// 52분
// 일단 방문 여부와 내가 이때까지 각기 다른 벽을 깬 횟수에 따라서 다뤄야 하는게 조금 난감했다
// 문제 자체는 쉬웠으나 내가 오타나서 cy cx 의 현재값을 ny nx 로 더해야되는데 오타나서 오래걸렸고
// 또 더해서 내가 벽을 덜깼을 때 방문했던 곳은 다시 방문 안하게끔 해야되는데
// 만약 현재 내가 2개깻는데 1개꺴을 때 방문했던곳을 내가 방문 여부 체크하려면
// for 반복문을 통해서 0개깻을 때 부터 현재 brokenWall 갯수까지의 방문 여부를 따져서 할수 밖에없다
// 또 만약 벽일 때 brokenWall 랑 K를 비교하고 또 벽을 깨고 그자리에 누군가가 안갔었다면
// 내가 벽을 깨고 갈 수 있고
// 또 방문도 안했고 벽도 없으면 그냥 BFS 플러드필로 나아간다.

// 개선점
/*
                boolean visit = false;

                for (int w = 0; w <= brokenWall; w++) {
                    if (dist[ny][nx][w] != 0) {
                        visit = true;
                        break;
                    }
                }
                if (visit) {
                    continue;
                }
 */