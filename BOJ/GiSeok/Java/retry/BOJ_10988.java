/**
 * 00:09:08 B3
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        System.out.println(pel(word));
    }

    private static int pel(String word) {
        for (int idx = 0; idx < word.length() / 2; idx++) {
            if (word.charAt(idx) != word.charAt(word.length() - idx - 1)) {
                return 0;
            }
        }
        return 1;
    }
}
