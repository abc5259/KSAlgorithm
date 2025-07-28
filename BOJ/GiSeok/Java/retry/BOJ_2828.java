/**
 * 00:15:58 S5
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.*;

public class BOJ_2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int j = Integer.parseInt(br.readLine());

        int ans = 0;
        int left = 1;
        int right = m;
        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine());

            if (left <= apple) {
                if (right >= apple) continue;
                if (right < apple) {
                    int adder = apple - right;
                    ans += adder;
                    right = apple;
                    left += adder;
                }
            }
            if (left > apple) {
                int adder = left - apple;
                ans += adder;
                left = apple;
                right -= adder;
            }
        }

        System.out.println(ans);
    }
}
