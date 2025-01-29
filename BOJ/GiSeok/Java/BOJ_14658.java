/**
 * [G3 브루트포스] 하늘에서 별똥별이 빗발친다 - X
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] stars = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        int ret = 0;
        for (int s1 = 0; s1 < k; s1++) {
            int x = stars[s1][0];
            for (int s2 = 0; s2 < k; s2++) {
                int y = stars[s2][1];
                int cnt = 0;
                for (int s = 0; s < k; s++) {
                    if (x <= stars[s][0] && (x + l) >= stars[s][0] && y <= stars[s][1] && (y + l) >= stars[s][1]) cnt++;
                }

                ret = Math.max(ret, cnt);
            }
        }

        System.out.println(k - ret);
    }
}
