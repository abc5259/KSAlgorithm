/**
 * 1181 - 단어 정렬(S5) [O|00:10:43]
 * 구현, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) set.add(br.readLine());

        ArrayList<String> words = new ArrayList<>(set);
        words.sort((o1, o2) -> {
            if (o1.length() > o2.length())
                return 1;
            else if (o1.length() < o2.length())
                return -1;
            return o1.compareTo(o2);
        });

        for (String word : words)
            System.out.println(word);
    }
}
