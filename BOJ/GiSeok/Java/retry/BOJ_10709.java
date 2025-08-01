package BOJ.GiSeok.Java.retry;

// 00:14:24

import java.util.*;
import java.io.*;

public class BOJ_10709 {
    
    static class Cloud {
        int y, x;

        public Cloud(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(map[i], -1);
        }

        Deque<Cloud> q = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            String input = br.readLine();
            for (int j = 0; j < w; j++) {
                if (input.charAt(j) == 'c') {
                    q.add(new Cloud(i, j));
                    map[i][j] = 0;
                }
            }
        }

        int day = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Cloud c = q.poll();

                int ny = c.y;
                int nx = c.x + 1;

                if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                    continue;
                }

                if (map[ny][nx] == -1) {
                    map[ny][nx] = day;
                } else if (map[ny][nx] != 0) {
                    map[ny][nx] = Math.min(map[ny][nx], day);
                }
                q.add(new Cloud(ny, nx));
            }

            day++;
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
    }
}
