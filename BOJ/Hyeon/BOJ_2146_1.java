package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2146_1 {
    static int N;
    static int[][] dist;
    static int[][] numbers;
    static ArrayDeque<int[]> bridgeQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dist = new int[N][N];
        numbers = new int[N][N];
        bridgeQueue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    numbers[i][j] = -1;
                }
            }
        }

        int islandId = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (numbers[i][j] == -1) {
                    labelIsland(i, j, ++islandId);
                }
            }
        }
        System.out.println(bfsBridge());
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void labelIsland(int y, int x, int id) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        numbers[y][x] = id;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            boolean isCoast = false;

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }
                if (numbers[ny][nx] == -1) {
                    queue.offer(new int[]{ny, nx});
                    numbers[ny][nx] = id;
                } else if (numbers[ny][nx] == 0) {
                    isCoast = true;
                }
            }
            if (isCoast) {
                bridgeQueue.offer(new int[]{cy, cx});
                dist[cy][cx] = 0;
            }
        }
    }

    static int bfsBridge() {
        int minDist = Integer.MAX_VALUE;

        while (!bridgeQueue.isEmpty()) {
            int[] poll = bridgeQueue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }
                if (numbers[ny][nx] == 0) {
                    bridgeQueue.offer(new int[]{ny, nx});
                    dist[ny][nx] = dist[cy][cx] + 1;
                    numbers[ny][nx] = numbers[cy][cx];
                } else if (numbers[ny][nx] != numbers[cy][cx]) {
                    minDist = Math.min(minDist, dist[ny][nx] + dist[cy][cx]);
                }
            }
        }
        return minDist;
    }
}
// G3 다리 만들기 BFS
// 다시 내 코드를 효율적으로 개선한 코드 너무 길고 중복이 있어서
// 일단 첫번째로 섬이냐 바다냐 입력에 대해서 기존에는 boolean 타입의 map으로 섬과바다를 구분하였고
// dist 로 각 섬의 해안가에서 부터 만들 수 있는 다리의 최단길이를 측정한다 근데 모든 섬에서 일정하게 만들어야 최단거리를 알 수 있으니까
// 각 해안가를 큐에 넣고 bfs 를 돌려야 한다는 것이다
// 그렇다면 각 해안가가 어느 섬인줄 알고? 다른 섬이랑 만나서 최단거리르 ㄹ만들어야 되기 때문에 각 해안가 즉 땅이 가진 번호가 필요했다
// 그래서 numbers 라는 배열을 통해서 각 섬의 번호를 얻으려 햇는데 그럼 1,2,3 이 섬일테고 바다는 0으로 잡으면 된다 그러면
// map 이라는 boolean 대신 numbers 라는 기존의 섬 번호 배열 1개로도 충분히 가능하다 1이라는 입력값인 땅을 모두 -1로
// 초기화 해두고 -1일 때를 퍼져나가서 각 섬의 번호를 얻게 하는게 labelIsland 이다.
// 또 거리는 0부터 시작하기에 모든 값을 -1로 초기화하고 해안가를 다 0으로 설정해둔다.
// 그래서이 해안가에 대한 좌표를 얻어야 하기 때문에 bridgeQueue 를 만들고 여기에다가 넣어주고
// 아까 구하고자 했던 섬에 있어서는 주변에 1개도 바다가 아니면 계속 퍼져나가서 섬의 번호 islandId 를 가지고
// 1면이라도 바다라면 걔는 해안가로 낙첨된다.
// 그리고 이제 각 해안가에서 bfs 를 돌리는데 내가 만약에 가다가 다른 해안가에서 온 최단거리랑 만날때 이때 값들의 합중
// 최저를 구하는 것이다.