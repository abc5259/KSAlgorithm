/**
 * [G4 다익스트라] 녹색 옷 입은 애가 젤다지? - O, 00:13:12
 * 시도 1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4485 {

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int[][] dungeon;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            dungeon = new int[n][n];

            for (int y = 0; y < n; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) dungeon[y][x] = Integer.parseInt(st.nextToken());
            }

            int[][] shortest = dijkstra(0, 0);
            System.out.println("Problem " + t++ + ": " + shortest[n-1][n-1]);
        }
    }

    public static int[][] dijkstra(int y, int x) {
        int[][] shortest = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(shortest[i], 987654321);
        shortest[y][x] = dungeon[y][x];

        boolean[][] visited = new boolean[n][n];

        while (true) {
            int smallY = 0;
            int smallX = 0;
            int value = Integer.MAX_VALUE;
            for (int yy = 0; yy < n; yy++) {
                for (int xx = 0; xx < n; xx++) {
                    if (!visited[yy][xx] && value > shortest[yy][xx]) {
                        value = shortest[yy][xx];
                        smallY = yy;
                        smallX = xx;
                    }
                }
            }

            if (smallY == n-1 && smallX == n-1) break;
            visited[smallY][smallX] = true;

            for (int i = 0; i < 4; i++) {
                int ny = smallY + dy[i];
                int nx = smallX + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (visited[ny][nx]) continue;

                shortest[ny][nx] = Math.min(shortest[smallY][smallX] + dungeon[ny][nx], shortest[ny][nx]);
            }
        }

        return shortest;
    }
}
