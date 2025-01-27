/**
 * [B3 구현|수학] 삼각형과 세 변 - O, 00:05:13
 * 시도 3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;
            if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
                System.out.println("Invalid");
                continue;
            }

            if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if ((a == b) || (c == b) || (a == c)) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
