package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    int res = bfs(i, j);
                    if (res > max) {
                        max = res;
                    }
                }
            }
        }
        System.out.println(max);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x) {
        boolean[][] visit = new boolean[N][M];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x, 0});
        visit[y][x] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];
            int hour = poll[2];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] != 'L' || visit[ny][nx]) {
                    continue;
                }
                queue.offer(new int[]{ny, nx, hour + 1});
                cnt = hour + 1;
                visit[ny][nx] = true;
            }
        }
        return cnt;
    }
}

// G5 보물섬 BFS 브루트포
// 18분
// 일단 육지간의 가장 길었을 때의 기준인데 보물은 항상 끝과 끝에 있기 때문에
// 이를 위한 최단거리를 구한다 그래서 이건 BFS 인가 싶었다 가중치도 1시간으로 일치 해서
// 그런데 내가 보물의 위치를 모르니까 보물을 어떻게 찾나 생각했는데 생각해보니 각 육지에서부터
// 내가갈 수 있는 가장 먼곳이 보물의 위치라고 생각한거고 그때 가장 큰 거리가 내가 보물을 찾을 수 있는 가장 최단 거리
// 그래서 각 육지별로 내가 얻을 수 있는 보물의 위치를 가지는게 res 배열이고
// 각 육지 반복마다 visit 배열을 써야 하기에 bfs 내부에서 쓰고 cnt 로 bfs 태울때 시간도 저장해서 쓴다
// 가로 세로가 50이기에 시간복잡도가 괜찮을거 같아서 풀었다.