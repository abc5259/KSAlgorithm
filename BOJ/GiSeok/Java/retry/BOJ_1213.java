/**
 * 00:47:55 S3
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] alphabet = new int[26];
        for (int idx = 0; idx < input.length(); idx++) {
            alphabet[input.charAt(idx) - 'A']++;
        }

        int isOne = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 != 0) isOne++;
        }

        StringBuilder sb = new StringBuilder();
        String ans = "";
        if (isOne > 1) ans += "I'm Sorry Hansoo";
        else {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alphabet[i] / 2; j++) {
                    sb.append((char) (i + 'A'));
                }
            }
            ans = sb.toString();
            String end = sb.reverse().toString();

            for (int i = 0; i < 26; i++) {
                if (alphabet[i] % 2 != 0) {
                    ans += (char) (i + 'A');
                }
            }

            ans += end;
        }

        System.out.println(ans);
    }
}
