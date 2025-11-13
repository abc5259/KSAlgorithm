package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2234 {
    static int N, M;
    static int[][] castle;
    static int[][] extent;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        castle = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        extent = new int[M][N];

        int max = 0, cnt = 0, total = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (extent[i][j] == 0) {
                    list = new ArrayList<>();

                    int tmp = bfs(i, j);

                    max = Math.max(max, tmp);

                    cnt++;

                    for (int[] pair : list) {
                        extent[pair[0]][pair[1]] = tmp;
                        castle[pair[0]][pair[1]] = cnt;
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i + 1 < M && castle[i][j] != castle[i + 1][j]) {
                    total = Math.max(total, extent[i][j] + extent[i + 1][j]);
                }
                if (j + 1 < N && castle[i][j] != castle[i][j + 1]) {
                    total = Math.max(total, extent[i][j] + extent[i][j + 1]);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
        System.out.println(total);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] bit = {2, 4, 8, 1};

    static int bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        list.add(new int[]{y, x});
        extent[y][x] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                if ((castle[cy][cx] & bit[i]) == bit[i]) {
                    continue;
                }

                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= M || nx >= N || extent[ny][nx] != 0) {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                list.add(new int[]{ny, nx});
                extent[ny][nx] = 1;
            }
        }
        return list.size();
    }
}
// G3 성곽 BFS, 비트
// 55분
// 일단 BFS 라고 쉽게 생각했다 왜냐하면 한번 간 길은 무를 수 없다는 게 조건인데
// 여기도 벽이 막히면 끝이기 때문에 BFS 라고 생각했고
// 더해서 방의 개수, 방의 최고 넓이, 벽이 1개라도 없어지면 가질 수 있는 최대 넓이를 구해야했다
// 그래서 방의 개수는 bfs 의 연산 횟수, 최고 넓이는 bfs 의 탐색 횟수 즉 방문 여부로 이를 나타냈고
// 벽이 1개라도 없어진다는 가정은 해당 bfs 의 방의 연산 횟수를 통해서 각 방끼리를 구분해가지고 list 로 저장 해둔 좌표들을
// 다시 castle 의 벽 정보는 이미 탐색했으면 필요없기에 덮어 씌워서 이를 구분하는 용도로 사용해서
// 1개 없어지는 것에 대한 연산을 해서 total을 구했다.
// 개선 점
// 일단 방의 개수는 list.size()로 해결 할 수 있었다 왜냐하면 bfs 의 좌표를 계속 저장해두었었기 때문
// 그래서 bfs 연산에 쓸데 없는 비교를 없앴다.