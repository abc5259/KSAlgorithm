/**
 * 28702 - FizzBuzz(B1) [O|00:16:27]
 * 구현, 시도2
 */
package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        for (int i = 3; i >= 1; i--) {
            String str = br.readLine();
            if (!(str.startsWith("F") || str.startsWith("B"))) {
                num = Integer.parseInt(str) + i;
                break;
            }
        }

        String ret = String.valueOf(num);
        if (num % 3 == 0 && num % 5 == 0) ret = "FizzBuzz";
        else if (num % 3 == 0) ret = "Fizz";
        else if (num % 5 == 0) ret = "Buzz";

        System.out.println(ret);
    }
}
