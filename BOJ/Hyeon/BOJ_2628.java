package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2628 {
    static int R, C;
    static boolean[] rowCuts;
    static boolean[] colCuts;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        rowCuts = new boolean[R + 1];
        colCuts = new boolean[C + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());

            if (dir == 0) {
                rowCuts[line] = true;
            } else {
                colCuts[line] = true;
            }
        }

        visit = new boolean[R][C];
        int max = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visit[i][j]) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        System.out.println(max);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        int size = 1;
        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ny][nx]) {
                    continue;
                }
                int checkRow = Math.max(cy, ny);
                int checkCol = Math.max(cx, nx);

                if (ny != cy && rowCuts[checkRow]) {
                    continue;
                }
                if (nx != cx && colCuts[checkCol]) {
                    continue;
                }

                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
                size++;
            }
        }

        return size;
    }
}
// S5 종이자르기 BFS
// 30분
// 좀 억지스럽게 푼 느낌이 있는데 각 커넥티드 컴포넌트의 최대 넓이를 구해야 하고 이때
// 100 X 100 의 격자 이기에 브루트포스 돌려도 시간복잡도는 충분하다고 판단했다.
// k에 대해서도 최대 200이니까 100 * 100* 4 *200 이라고 생각
// 그래서 Cutting 으로 클래스 따로 빼고 또 시작점이 벽보다 작으면 그 시작점이 움직인게 벽보다 항상 작아야된다
// 또 BFS 를 통해 방문 여부를 체크해서 벽보다 작으면 벽으로 둘러쌓인 넓이를 size 로 리턴받고
// 벽보다 클경우는 격자의 범위제한으로 통제한다.
// 개선된 코드
// Cutting 으로 k 가 200개의 반복문을 돌리지말고 boolean 타입의 행, 열 배열을 만들어서 O(1) 로 접근하게 끔한다
// dir 이 0일때 행 line 의 벽을 true 로 만들고 dir 이 1일때 열 line 에 벽을 true 로 세운다
// 그리고 이동하려는 좌표가 y가 변했는지 x 가 변했는지에 따라 어떤 벽을 마주할 것인가를 두고
// cy 와 ny 에 대해서 혹은 cx 와 nx 에 대해서 더 큰쪽 좌표에 벽이 있냐 없냐를 판별하면된다
// 세로로 이동중이라면 가로에 벽을 보고 가로로 이동중이라면 세로의 벽을 보면된다.