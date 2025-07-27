/**
 * 00:55:54 S1
 */
package BOJ.GiSeok.Java.retry.reretry;

import java.io.*;

public class BOJ_1992 {
    private static int[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j+1] = input.charAt(j) - '0';
            }
        }

        System.out.println(dfs(1, 1, n, n));
    }

    private static String dfs(int sy, int sx, int ey, int ex) {
        int num = map[sy][sx];

        for (int y = sy; y <= ey; y++) {
            for (int x = sx; x <= ex; x++) {
                if (map[y][x] != num) {
                    StringBuilder output = new StringBuilder();
                    output.append("(");
                    output.append(dfs(sy, sx, (sy+ey)/2, (sx+ex)/2));
                    output.append(dfs(sy, (sx+ex)/2+1, (sy+ey)/2, ex));
                    output.append(dfs((sy+ey)/2+1, sx, ey, (sx+ex)/2));
                    output.append(dfs((sy+ey)/2+1, (sx+ex)/2+1, ey, ex));
                    output.append(")");
                    return output.toString();
                }
            }
        }

        return String.valueOf(num);
    }
}
