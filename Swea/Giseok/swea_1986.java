/**
 * 1986. 지그재그 숫자 (D2|구현) [O|00:02:16]
 */
package Swea.Giseok;

import java.io.*;

public class swea_1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int m = 1; m <= n; m++) {
                if (m % 2 == 0) sum -= m;
                else sum += m;
            }

            System.out.println("#" + t + " " + sum);
        }
    }
}