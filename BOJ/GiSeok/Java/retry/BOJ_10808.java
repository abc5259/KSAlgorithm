/**
 * 00:05:48 B4
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];
        for (int idx = 0; idx < input.length(); idx++) {
            alphabet[input.charAt(idx) - 'a']++;
        }

        for (int idx = 0; idx < 26; idx++) {
            System.out.print(alphabet[idx] + " ");
        }
        System.out.println();
    }
}
