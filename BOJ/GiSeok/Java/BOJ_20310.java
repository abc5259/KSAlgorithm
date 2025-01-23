/**
 * [S3 그리디|문자열] 타노스 - X
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class BOJ_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<Character> list = new ArrayList<>();

        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero++;
            else one++;
            list.add(s.charAt(i));
        }

        zero /= 2;
        one /= 2;

        Iterator<Character> iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next() == '1') { iter.remove(); one--; }
            if (one == 0) break;
        }

        ListIterator<Character> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            if (iterator.previous() == '0') { iterator.remove(); zero--; }
            if (zero == 0) break;
        }

        list.stream()
                .forEach(c -> System.out.print(c));
    }
}
