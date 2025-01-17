/**
 * [G3 플로이드 워셜] 파티 - O, 00:21:37
 * 시도 4
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] shortest = new int[n+1][n+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) shortest[i][j] = 0;
                else shortest[i][j] = 987654321;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            shortest[v1][v2] = w;
        }

        for (int v1 = 1; v1 < n+1; v1++) {
            for (int v2 = 1; v2 < n + 1; v2++) {
                for (int v = 1; v < n + 1; v++) {
                    shortest[v2][v] = Math.min(shortest[v2][v], shortest[v1][v] + shortest[v2][v1]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i == x) continue;
            max = Math.max(shortest[i][x] + shortest[x][i], max);
        }
        System.out.println(max);
    }
}
