/**
 * 00:14:24 S5
 */
package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String aeiou = "aeiou";
        while (true) {
            String input = br.readLine();
            if (input.equals("end"))
                break;

            // check1
            boolean flag = false;
            for (int i = 0; i < input.length(); i++) {
                if (aeiou.contains(Character.toString(input.charAt(i)))) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println("<" + input + "> is not acceptable.");
                continue;
            }

            // check2
            int cnt1 = 0;
            int cnt2 = 0;
            boolean flag2 = false;
            for (int i = 0; i < input.length(); i++) {
                if (aeiou.contains(Character.toString(input.charAt(i)))) {
                    cnt1++;
                    cnt2 = 0;
                } else {
                    cnt2++;
                    cnt1 = 0;
                }

                if (cnt1 >= 3 || cnt2 >= 3) {
                    flag2 = true;
                    break;
                }
            }

            if (flag2) {
                System.out.println("<" + input + "> is not acceptable.");
                continue;
            }

            boolean flag3 = false;
            for (int i = 1; i < input.length(); i++) {
                char ch1 = input.charAt(i);
                char ch2 = input.charAt(i - 1);

                if (ch1 == 'e' && ch2 == 'e' || ch1 == 'o' && ch2 == 'o')
                    continue;
                if (ch1 == ch2) {
                    flag3 = true;
                    break;
                }
            }
            if (flag3) {
                System.out.println("<" + input + "> is not acceptable.");
                continue;
            }

            System.out.println("<" + input + "> is acceptable.");
        }
    }
}
