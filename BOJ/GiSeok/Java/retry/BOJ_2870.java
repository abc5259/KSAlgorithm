/**
 * 00:15:33 S4
 */
package BOJ.GiSeok.Java.retry;

import java.util.*;
import java.math.*;
import java.io.*;

public class BOJ_2870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<BigInteger> q = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            String num = "";
            for (int idx = 0; idx < input.length(); idx++) {
                char ch = input.charAt(idx);

                if ('0' <= ch && ch <= '9') {
                    num += ch;
                } else {
                    if (num.length() == 0) {
                        continue;
                    }
                    q.add(new BigInteger(num));
                    num = "";
                }
            }

            if (num.length() != 0) {
                q.add(new BigInteger(num));
            }
        }

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
