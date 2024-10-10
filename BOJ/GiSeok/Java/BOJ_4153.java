/**
 * 4153 - 직각삼각형
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_4153 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
            int b = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
            int c = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);

            if (a == 0 && b == 0 && c == 0) break;

            if (a + b == c || a + c == b || b + c == a) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
