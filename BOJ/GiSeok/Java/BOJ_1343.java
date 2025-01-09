/**
 * [S5 문자열] 폴리오미노 - O, 00:07:05
 * 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int idx = 0; idx < board.length(); idx++) {
            if (board.charAt(idx) == 'X') cnt++;
            else {
                sb.append(find(cnt)).append(".");
                cnt = 0;
            }
        }

        if (cnt != 0) sb.append(find(cnt));

        System.out.println(sb.toString().contains("-1") ? -1 : sb.toString());
    }

    private static String find(int cnt) {
        StringBuilder sb = new StringBuilder();
        if (cnt % 2 != 0) return "-1";

        while (cnt != 0) {
            if (cnt >= 4) {
                sb.append("AAAA");
                cnt -= 4;
                continue;
            }

            sb.append("BB");
            cnt -= 2;
        }

        return sb.toString();
    }
}
