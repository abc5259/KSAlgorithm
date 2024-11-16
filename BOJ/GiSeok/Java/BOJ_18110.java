/**
 * 18110 - solved.ac(S4/구현) [O|00:12:24]
 * 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for (int i = 0; i < n; i++) score[i] = Integer.parseInt(br.readLine());
        Arrays.sort(score);

        int ret = 0;
        int exclude = Math.round(n * 0.15f);
        for (int i = exclude; i < n - exclude; i++) {
            ret += score[i];
        }

        if (ret != 0) ret = Math.round(ret / (n - exclude * 2.0f));
        System.out.println(ret);
    }
}
