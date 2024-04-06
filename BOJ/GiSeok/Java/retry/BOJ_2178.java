package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] m = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(m[j]);
            }
        }

        mazerunner(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    static void mazerunner(int startx, int starty) {
        int[][] wasd = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        Queue<Integer> q = new LinkedList<>();

        q.add(startx);
        q.add(starty);

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int i = 0; i < 4; i++) {
                int[] dir = wasd[i];

                int nx = x + dir[0];
                int ny = y + dir[1];

                if ((nx >= 0 && nx < M) && (ny >= 0 && ny < N)) {
                    if (map[ny][nx] == 1) {
                        map[ny][nx] = map[y][x] + 1;
                        q.add(nx);
                        q.add(ny);
                    }
                }
            }
        }
    }
}
