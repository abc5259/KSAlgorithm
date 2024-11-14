/**
 * 1945. 간단한 소인수분해 (D2|수학) [O]
 */
package Swea.Giseok;

import java.io.*;

public class swea_1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] prime = {2, 3, 5, 7, 11};
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            String[] ret = new String[5];
            for (int i = 0; i < 5; i++) {
                int cnt = 0;
                while (n % prime[i] == 0) {
                    n /= prime[i];
                    cnt++;
                }
                ret[i] = String.valueOf(cnt);
            }

            System.out.println("#" + t + " " + String.join(" ", ret));
        }
    }
}