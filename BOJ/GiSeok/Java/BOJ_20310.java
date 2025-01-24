/**
 * [S3 그리디|문자열] 타노스 - X
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class BOJ_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int zero = 0;
        int one = 0;
        for (int idx = 0; idx < chars.length; idx++) {
            if (chars[idx] == '0') zero++;
            else one++;
        }
        zero /= 2;
        one /= 2;

       for (int idx = 0; idx < chars.length; idx++) {
           if (chars[idx] == '1') {
               if (one > 0) chars[idx] = ' ';
               one--;
           }
           if (chars[chars.length - idx - 1] == '0') {
               if (zero > 0) chars[chars.length - idx - 1] = ' ';
               zero--;
           }
       }

        for (char c : chars) {
            if (c != ' ') System.out.print(c);
        }
    }
}
