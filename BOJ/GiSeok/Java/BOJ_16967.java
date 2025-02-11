/**
 * [S3 구현] 배열 복원하기 - O, 00:15:15
 * 시도 1
 * 시간 복잡도 300^2 + 300^2 = 180,000
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] b = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
                if (i >= x && j >= y) b[i][j] -= b[i - x][j - y];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(b[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
