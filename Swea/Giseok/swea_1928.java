/**
 * 1928. Base64 Decoder (D2|구현) [O|00:30:00]
 */
package Swea.Giseok;

import java.io.*;

public class swea_1928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String encoding = br.readLine();
            String builder = "";
            for (int idx = 0; idx < encoding.length(); idx++) {
                char at = encoding.charAt(idx);

                int tmp;
                if ('A' <= at && 'Z' >= at)  tmp = at - 'A';
                else if ('a' <= at && 'z' >= at) tmp = at - 'a' + 26;
                else if ('0' <= at && '9' >= at) tmp = at - '0' + 52;
                else if (at == '+') tmp = 62;
                else tmp = 63;

                String tmpbuilder = "";
                for (int i = 0; i < 6; i++) {
                    tmpbuilder = (tmp % 2) + tmpbuilder;
                    tmp /= 2;
                }
                builder += tmpbuilder;
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < builder.length(); i+=8) {
                System.out.printf("%c", Integer.parseInt(builder.substring(i, i+8), 2));
            }
            System.out.println();
        }
    }
}