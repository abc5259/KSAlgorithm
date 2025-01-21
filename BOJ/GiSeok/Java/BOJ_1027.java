/**
 * [G4 수학] 고층 건물 - X
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buildings = new int[n+1];
        for (int i = 1; i <= n; i++) buildings[i] = Integer.parseInt(st.nextToken());

        int ret = 0;
        for (int a = 1; a <= n; a++) {
            int cnt = 0;
            double tmp = 0;

            for (int b = a-1; b >= 1; b--) {
                double m = (double) (buildings[a] - buildings[b]) / (a - b);

                if (b == a-1 || tmp > m) {
                    tmp = m;
                    cnt++;
                }
            }

            for (int b = a+1; b <= n; b++) {
                double m = (double)(buildings[a] - buildings[b]) / (a - b);

                if (b == a+1 || tmp < m) {
                    cnt++;
                    tmp = m;
                }
            }

            ret = Math.max(ret, cnt);
        }

        System.out.println(ret);
    }
}
