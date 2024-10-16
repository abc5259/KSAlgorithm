/**
 * 1213. [S/W 문제해결 기본] 3일차 - String (D3|문자열) [O|00:06:21]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;

public class swea_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            br.readLine();
            String find = br.readLine();
            String str = br.readLine();

            int originalLen = str.length();
            int findLen = str.replace(find, "").length();

            System.out.println("#" + i + " " + ((originalLen - findLen) / find.length()));
        }
    }
}
            