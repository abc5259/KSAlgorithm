/**
 * 11866 - 요세푸스 문제 0(S4/구현) [O|00:29:21]
 * 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] killed = new boolean[n];

        System.out.print("<");
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (true) {
                if (!killed[idx]) cnt++;
                if (cnt == k) break;
                idx = (idx + 1) % n;
            }

            killed[idx] = true;
            if (i != n-1) System.out.print(idx+1 + ", ");
            else System.out.print(idx+1);
        }
        System.out.println(">");
    }
}
