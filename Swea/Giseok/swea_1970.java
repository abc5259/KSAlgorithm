/**
 * 1970. 쉬운 거스름돈 (D2|구현) [O|00:05:21]
 */
package Swea.Giseok;

import java.io.*;

public class swea_1970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] cash = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        String[] ret = new String[8];
        for (int t = 1; t <= T; t++) {
            int money = Integer.parseInt(br.readLine());

            for (int i = 0; i < 8; i++) {
                ret[i] = String.valueOf(money / cash[i]);
                money %= cash[i];
            }

            System.out.println("#" + t);
            System.out.println(String.join(" ", ret));
        }
    }
}