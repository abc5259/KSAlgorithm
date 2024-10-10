package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_2775 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] apart = new int[15][16];

        for (int i = 1; i <= 15; i++) apart[0][i] = i;

        for (int y = 1; y <= 14; y++) {
            for (int x = 1; x <= 14; x++) {
                for (int xx = 1; xx <= x; xx++)
                    apart[y][x] += apart[y-1][xx];
            }
        }

        for (int tc = 1; tc <= t; tc++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(apart[k][n]);
        }
    }
}