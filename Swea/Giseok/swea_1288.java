/**
 * 1288. 새로운 불면증 치료법 (D2|구현) [O|00:15:59]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1288 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();

            int cnt = 0;
            while (set.size() < 10) {
                int num = n * ++cnt;
                String numstr = String.valueOf(num);
                for (int i = 0; i < numstr.length(); i++) set.add((numstr.charAt(i) - '0'));
            }

            System.out.println("#" + t + " " + (n * cnt));
        }
    }
}