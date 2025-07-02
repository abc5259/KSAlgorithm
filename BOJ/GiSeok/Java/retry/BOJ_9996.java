/**
 * 00:16:39 S3
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        String patternStart = pattern.split("\\*")[0];
        String patternEnd = pattern.split("\\*")[1];

        for (int i = 0; i < n; i++) {
            String plain = br.readLine();

            if (plain.startsWith(patternStart)) {
                plain = plain.replace(patternStart, "");

                if (plain.endsWith(patternEnd)) {
                    System.out.println("DA");
                    continue;
                }
            }
            System.out.println("NE");
        }
    }
}
