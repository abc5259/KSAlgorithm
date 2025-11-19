package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2146 {
    static int N;
    static boolean[][] map;
    static int[][] dist;
    static ArrayDeque<int[]> queue;
    static int[][] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int var = Integer.parseInt(st.nextToken());
                if (var == 1) {
                    map[i][j] = true;
                }
            }
        }
        numbers = new int[N][N];

        int national = 0;

        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] && numbers[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    numbers[i][j] = ++national;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int ny = poll[0] + dy[d];
                            int nx = poll[1] + dx[d];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                                continue;
                            }
                            if (map[ny][nx] && numbers[ny][nx] == 0) {
                                queue.offer(new int[]{ny, nx});
                                numbers[ny][nx] = national;
                            }
                        }
                    }
                }
            }
        }

        dist = new int[N][N];

        for (int[] i : dist) {
            Arrays.fill(i, -1);
        }
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) {
                    boolean end = false;
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];

                        if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                            continue;
                        }
                        if (!map[ny][nx]) {
                            end = true;
                            break;
                        }
                    }
                    if (end) {
                        queue.offer(new int[]{i, j});
                    }
                    dist[i][j] = 0;
                }
            }
        }
        bfs();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i < N - 1 && numbers[i][j] != numbers[i + 1][j]) {
                    min = Math.min(min, dist[i][j] + dist[i + 1][j]);
                }
                if (j < N - 1 && numbers[i][j] != numbers[i][j + 1]) {
                    min = Math.min(min, dist[i][j] + dist[i][j + 1]);
                }
            }
        }

        System.out.println(min);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs() {

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || dist[ny][nx] != -1) {
                    continue;
                }
                queue.offer(new int[]{ny, nx});

                if (map[ny][nx]) {
                    dist[ny][nx] = 0;
                } else {
                    dist[ny][nx] = dist[cy][cx] + 1;
                    numbers[ny][nx] = numbers[cy][cx];
                }
            }
        }
    }
}
// G3 다리 만들기 BFS
// 58분
// 와 진짜 어지럽게 풀었다 좀 정리를 하고 풀었어야 했는데 습관 좀 잡아야겠는데
// 일단 내가 하고자 한게 각 땅 별로 상대랑 이었을 때 최단 거리를 구해야 했는데 그렇다면
// 각 섬들에서 아무도 가지 않은 바다까지 나간다음에 누군가를 만났을때 그 합의 거리를 계산하면 된다고 생각했다
// 그래서 일단 첫번째로는 각 섬의 바다와 붙어있는 곳을 queue 에 넣어서 한번에 플러드 필 하려고 했다 즉
// 각각 바다로 칸을 나갈때 섬단위가 아닌 모든 해안가 기준으로 했다 왜냐하면
// bfs 에서 땅 기준으로 해버리면 첫번째 방문 섬이 모든 곳을 갈 수 있을테니까,,
// 그래서 queue를 밖으로 빼고 모든 해안가의 좌표를 넣은다음 bfs 를돌려서
// 가중치를 칸마다 + 1 씩 해서 채웠다 즉 이게 방문여부와 다리의 길이라 해서 dist 를 썻다
// 일단 섬이랑 바다를 0과 1로 두어서 이를 map 이라는 boolean 으로 사용했다
// 그런데 이게 문제가 뭐냐면 다리를 바다로 지었는데 이게 어느 섬에서 온지 모른다는 거다
// 그래서 그 섬의 좌표를 가지고 있어야 하니까 이 배열도 새로 생성해서
// numbers 라는 배열로 했고 플러드필 할때 섬의 번호를 가지고 가게 헀다
// 그래서 dist 를 초기화 하기전 섬이 0과 1로 분리됐을 때 끝이 바다일 때까지 나가서 섬에 번호를 national 로 매겼고
// 그를 사용해서 dist 배열의 완탐을 통해 붙어있는 다리의 길이를 합해서 최단거리를 구했다.