package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_30802 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] shirts = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) shirts[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += (shirts[i] / t);
            if (shirts[i] % t != 0) sum++;
        }

        System.out.println(sum);
        System.out.println((n / p) + " " + (n % p));
    }
}