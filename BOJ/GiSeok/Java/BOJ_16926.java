package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 지점을 0, 0 -> 1, 1 -> 2, 2 -> 3, 3 -> ... n / 2 - 1, n / 2 - 1
        for (int R = 0; R < r; R++) {
            int sy = 0;
            int sx = 0;

            while (sy < (n / 2) && sx < (m / 2)) {
                int tmp1 = A[sy][sx];
                int tmp2 = 0;
                for (int y = sy + 1; y < n - sy; y++) {
                    tmp2 = A[y][sx];
                    A[y][sx] = tmp1;
                    tmp1 = tmp2;
                }

                for (int x = sx + 1; x < m - sx - 1; x++) {
                    tmp2 = A[n - sy - 1][x];
                    A[n - sy - 1][x] = tmp1;
                    tmp1 = tmp2;
                }

                for (int y = n - sy - 1; y > sy; y--) {
                    tmp2 = A[y][m - sx - 1];
                    A[y][m - sx - 1] = tmp1;
                    tmp1 = tmp2;
                }

                for (int x = m - sx - 1; x >= sx; x--) {
                    tmp2 = A[sy][x];
                    A[sy][x] = tmp1;
                    tmp1 = tmp2;
                }

                sy++;
                sx++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
