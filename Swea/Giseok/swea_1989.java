/**
 * 1989. 초심자의 회문 검사 (D2|구현) [O|00:03:10]
 */
package Swea.Giseok;

import java.io.*;

public class swea_1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String line = br.readLine();
            int ret = 0;
            if (isPal(line)) ret = 1;

            System.out.println("#" + t + " " + ret);
        }
    }

    public static boolean isPal(String line) {
        int a = 0; int b = line.length() - 1;
        while (a <= b) {
            if (line.charAt(a) == line.charAt(b)) { a++; b--; }
            else return false;
        }
        return true;
    }
}