package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
    static int[][] square;
    static boolean[][] visit;
    static int time, cheese;
    static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        square = new int[row][col];


        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
                if (square[i][j] == 1) {
                    cheese++;
                }
            }
        }
        while (true) {
            visit = new boolean[row][col];
            int tmp = bfs();
            time++;
            if (cheese == tmp) {
                break;
            } else {
                cheese -= tmp;
            }
        }
        System.out.println(time);
        System.out.println(cheese);
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visit[0][0] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= row || nx >= col || visit[ny][nx]) {
                    continue;
                }
                visit[ny][nx] = true;
                if (square[ny][nx] == 0) {
                    queue.offer(new int[]{ny, nx});
                } else {
                    cnt++;
                    square[ny][nx] = 0;
                }
            }
        }
        return cnt;
    }
}

// G4 치즈 BFS
// 일단 풀었다.
