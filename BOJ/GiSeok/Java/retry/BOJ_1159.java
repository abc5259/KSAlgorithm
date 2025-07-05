/**
 * 00:12:59 B2
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[br.readLine().charAt(0) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= 5) {
                sb.append((char)('a' + i));
            }
        }

        if (sb.isEmpty()) {
            sb.append("PREDAJA");
        }

        System.out.println(sb);
    }
}
