/**
 * 1285. 아름이의 돌 던지기 (D2|구현) [O|00:08:50]
 */
package Swea.Giseok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1285 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] stone = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 100001;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                stone[i] = Integer.parseInt(st.nextToken());
                if (max > Math.abs(stone[i])) {
                    max = Math.abs(stone[i]);
                    cnt = 1;
                } else if (max == Math.abs(stone[i])) cnt++;
            }

            System.out.println("#" + t + " " + max + " " + cnt);
        }
    }
}
