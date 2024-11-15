/**
 * 1676 - 팩토리얼 0의 개수(S5) [O|00:11:40]
 * 수학
 */
package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_1676_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num % 5 == 0) {
                num /= 5;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
