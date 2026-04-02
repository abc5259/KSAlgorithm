package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_11478 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            for (int idx = 0; idx < s.length() - i; idx++) {
                set.add(s.substring(idx, idx + i + 1));
            }
        }

        System.out.println(set.size());
    }
}
