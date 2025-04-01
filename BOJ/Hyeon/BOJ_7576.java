package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int[][] matrix;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    res = Math.max(matrix[i][j], res);
                }
            }
        }
        System.out.println(res - 1);
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int y = arr[0];
            int x = arr[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M && matrix[ny][nx] == 0) {
                    matrix[ny][nx] = matrix[y][x] + 1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}
// G5 토마토 BFS
// 쉽게 생각할 수 있지만 푸는데 오래 걸렸다
// 인접 리스트를 사용하지않고 주어진 입력이 메트릭스여서 인접 행렬로 풀었다
// 행렬의 값이 1이면 큐에 바로바로 입력하고 큐에서 읽었을 때 기저조건을 설정하여 차곡차곡 다음날의 값을 BFS에 넣고
// 큐에 다시 offer했다. 이때 시작날이 1일이라 -1일 해주어야하고, 0이어야 들릴 수 있는 곳으로 -1은 안된다.