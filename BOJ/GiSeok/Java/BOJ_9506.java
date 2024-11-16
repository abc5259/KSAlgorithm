/**
 * 9506 - 약수들의 합(B1) [O]
 * 수학, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            int sum = 0;
            StringBuilder sb = new StringBuilder().append(n).append(" = ");
            for (int m = 1; m < n; m++) {
                if (n % m == 0) {
                    sum+=m;
                    sb.append(m).append(" + ");
                }
            }

            if (sum == n) {
                sb.replace(sb.length() - 3, sb.length(), "");
            } else {
                sb = new StringBuilder().append(n).append(" is NOT perfect.");
            }

            System.out.println(sb);
        }
    }
}